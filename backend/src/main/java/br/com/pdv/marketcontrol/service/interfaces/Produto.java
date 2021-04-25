package br.com.pdv.marketcontrol.service.interfaces;

import br.com.pdv.marketcontrol.model.dto.ProdutoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Produto {

    public Page<ProdutoDTO> findAll(Pageable pageable);
}
