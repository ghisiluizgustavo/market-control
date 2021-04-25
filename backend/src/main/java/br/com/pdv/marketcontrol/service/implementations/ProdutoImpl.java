package br.com.pdv.marketcontrol.service.implementations;

import br.com.pdv.marketcontrol.model.dto.ProdutoDTO;
import br.com.pdv.marketcontrol.repository.ProdutoRepository;
import br.com.pdv.marketcontrol.service.interfaces.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProdutoImpl implements Produto {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public Page<ProdutoDTO> findAll(Pageable pageable) {
        return null;
    }
}
