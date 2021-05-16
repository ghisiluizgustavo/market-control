package br.com.pdv.marketcontrol.service;

import br.com.pdv.marketcontrol.model.Venda;
import br.com.pdv.marketcontrol.model.dto.VendaDTO;
import br.com.pdv.marketcontrol.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

    @Autowired
    VendaRepository vendaRepository;

    public Page<VendaDTO> findAll(@PageableDefault(
            sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
        Page<Venda> vendas = vendaRepository.findAll(pageable);
        return VendaDTO.converter(vendas);
    }
}
