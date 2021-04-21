package br.com.pdv.marketcontrol.controller;

import br.com.pdv.marketcontrol.model.Produto;
import br.com.pdv.marketcontrol.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping()
    public ResponseEntity<List<Produto>> listarProdutos(){

        List<Produto> listaProd = this.produtoRepository.findAll();

        return ResponseEntity.ok(listaProd);
    }

    @PostMapping()
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto, UriComponentsBuilder uriBuilder){
        Produto produtoResultado = this.produtoRepository.save(produto);
        URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produtoResultado.getId()).toUri();

        return ResponseEntity.created(uri).body(produtoResultado);
    }
}
