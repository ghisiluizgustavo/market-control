package br.com.pdv.marketcontrol.controller;

import br.com.pdv.marketcontrol.model.Produto;
import br.com.pdv.marketcontrol.model.Venda;
import br.com.pdv.marketcontrol.model.dto.ProdutoDTO;
import br.com.pdv.marketcontrol.model.dto.VendaDTO;
import br.com.pdv.marketcontrol.repository.ProdutoRepository;
import br.com.pdv.marketcontrol.repository.VendaRepository;
import br.com.pdv.marketcontrol.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    VendaService service;

    @GetMapping()
    public ResponseEntity<Page<VendaDTO>> buscarTodasVendas(
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
        Page<VendaDTO> listaVenda = this.service.buscarTodasVendas(pageable);
        return ResponseEntity.ok(listaVenda);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaDTO> buscarVenda(@PathVariable Long id){
        return this.service.buscarVenda(id)
                .map(venda -> ResponseEntity.ok().body(new VendaDTO(venda)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<VendaDTO> salvarVenda(
            @RequestBody Venda venda, UriComponentsBuilder uriBuilder){
        Venda vendaResponse = this.service.salvar(venda);
        URI uri = uriBuilder
                .path("/vendas/{id}")
                .buildAndExpand(vendaResponse.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new VendaDTO(vendaResponse));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendaDTO> atualizarVenda(
            @PathVariable Long id, @RequestBody Venda venda) {
        return service.atualizar(id)
                .map(vendaResponse -> ResponseEntity.accepted().body(
                        new VendaDTO(this.service.salvar(venda))))
                .orElse(ResponseEntity.badRequest().build());
    }
}
