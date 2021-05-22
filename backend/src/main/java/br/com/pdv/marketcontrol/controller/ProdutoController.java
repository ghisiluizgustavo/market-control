package br.com.pdv.marketcontrol.controller;

import br.com.pdv.marketcontrol.model.Produto;
import br.com.pdv.marketcontrol.model.dto.ProdutoDTO;
import br.com.pdv.marketcontrol.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/produtos")
@Api("API Rest de produtos [CRUD]")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping()
    @ApiOperation("Retorna todos produtos")
    public ResponseEntity<Page<ProdutoDTO>> listarProdutos(
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        Page<ProdutoDTO> listaProd = produtoService.buscarTodosProdutos(pageable);
        return ResponseEntity.ok(listaProd);
    }

    @GetMapping("/{codBarras}")
    public ResponseEntity<ProdutoDTO> buscarProduto(@PathVariable String codBarras){
          return produtoService.buscarProduto(codBarras)
                  .map(produto -> ResponseEntity.ok().body(ProdutoDTO.converter(produto)))
                  .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<ProdutoDTO> salvarProduto(
            @RequestBody Produto produto, UriComponentsBuilder uriBuilder){
        Produto prodResponse = this.produtoService.salvar(produto);
        URI uri = uriBuilder
                .path("/produtos/{id}")
                .buildAndExpand(prodResponse.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new ProdutoDTO(prodResponse));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizarProduto(
            @PathVariable Long id, @RequestBody Produto produto){
        return produtoService.atualizar(id)
                .map(prodResponse -> ResponseEntity.accepted().body(
                        new ProdutoDTO(this.produtoService.salvar(produto))))
                .orElse(ResponseEntity.badRequest().build());
    }
}
