package br.com.pdv.marketcontrol.controller;

import br.com.pdv.marketcontrol.model.Produto;
import br.com.pdv.marketcontrol.model.Venda;
import br.com.pdv.marketcontrol.repository.ProdutoRepository;
import br.com.pdv.marketcontrol.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    VendaRepository vendaRepository;

    @GetMapping()
    public ResponseEntity<List<Venda>> listAllProdutos(){

        List<Venda> listaVenda = this.vendaRepository.findAll();

        return ResponseEntity.ok(listaVenda);
    }
}
