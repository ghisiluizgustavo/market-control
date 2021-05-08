package br.com.pdv.marketcontrol.service;

import br.com.pdv.marketcontrol.model.Produto;
import br.com.pdv.marketcontrol.model.dto.ProdutoDTO;
import br.com.pdv.marketcontrol.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService{

    @Autowired
    ProdutoRepository produtoRepository;

    public Page<ProdutoDTO> findAll(
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {

        Page<Produto> produtos = produtoRepository.findAll(pageable);
        return ProdutoDTO.converter(produtos);
    }

    public Optional<Produto> findOneProduct(String codBarras){
        return produtoRepository.findByCodBarras(codBarras);
    }
}
