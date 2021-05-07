package br.com.pdv.marketcontrol.service;

import br.com.pdv.marketcontrol.model.Produto;
import br.com.pdv.marketcontrol.model.dto.ProdutoDTO;
import br.com.pdv.marketcontrol.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

public class ProdutoService{

    @Autowired
    ProdutoRepository produtoRepository;

    public Page<ProdutoDTO> findAll(
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {

        Page<Produto> produtos = produtoRepository.findAll(pageable);
        return ProdutoDTO.converter(produtos);
    }
}
