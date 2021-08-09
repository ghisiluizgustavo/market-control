package br.com.pdv.marketcontrol.controller;

import br.com.pdv.marketcontrol.model.Produto;
import br.com.pdv.marketcontrol.model.dto.ProdutoDTO;
import br.com.pdv.marketcontrol.service.ProdutoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping()
    public ModelAndView listarProdutos(
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<ProdutoDTO> produtos = produtoService.buscarTodosProdutos(pageable);
        ModelAndView mv = new ModelAndView("produtos/produtos");
        mv.addObject("produtos", produtos);
        return mv;
    }

    @GetMapping("/pesquisar")
    @ResponseBody
    public String buscarProduto(@RequestParam String codBarras) {
        Optional<Produto> prod = this.produtoService.buscarProduto(codBarras);
        if (prod.isPresent()) {
            return "Produto => " + prod.toString();
        }
        return "Produto não encontrado";
    }

    @GetMapping("/novo")
    public String novo() {
        return "produtos/novo-produto";
    }

    @PostMapping()
    public ResponseEntity<ProdutoDTO> salvarProduto(
            @RequestBody Produto produto, UriComponentsBuilder uriBuilder) {
        Produto prodResponse = this.produtoService.salvar(produto);
        URI uri = uriBuilder
                .path("/produtos/{id}")
                .buildAndExpand(prodResponse.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new ProdutoDTO(prodResponse));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizarProduto(
            @PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.buscarId(id)
                .map(prodResponse -> ResponseEntity.accepted().body(
                        new ProdutoDTO(this.produtoService.salvar(produto))))
                .orElse(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarProduto(@PathVariable Long id) {
        return produtoService.buscarId(id)
                .map(produto -> produtoService.deletar(id))
                .orElse(ResponseEntity.notFound().build());
    }
}
