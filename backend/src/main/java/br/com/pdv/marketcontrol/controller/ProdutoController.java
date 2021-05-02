package br.com.pdv.marketcontrol.controller;

import br.com.pdv.marketcontrol.model.Produto;
import br.com.pdv.marketcontrol.model.dto.ProdutoDTO;
import br.com.pdv.marketcontrol.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{codBarras}")
    public ResponseEntity<Produto> buscarProduto(@PathVariable String codBarras){
        Optional<Produto> response = produtoRepository.findByCodBarras(codBarras);
        //TODO -> Fazer uma função lambda(funcional)
        if(response.isPresent()){
            return ResponseEntity.ok().body(response.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto, UriComponentsBuilder uriBuilder){
        Produto produtoResultado = this.produtoRepository.save(produto);
        URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produtoResultado.getId()).toUri();

        return ResponseEntity.created(uri).body(produtoResultado);
    }
}
