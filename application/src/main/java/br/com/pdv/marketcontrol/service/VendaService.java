package br.com.pdv.marketcontrol.service;

import br.com.pdv.marketcontrol.model.Produto;
import br.com.pdv.marketcontrol.model.Venda;
import br.com.pdv.marketcontrol.model.dto.VendaDTO;
import br.com.pdv.marketcontrol.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    VendaRepository vendaRepository;

    public Page<VendaDTO> buscarTodasVendas(@PageableDefault(
            sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
        Page<Venda> vendas = vendaRepository.findAll(pageable);
        return VendaDTO.converter(vendas);
    }

    public Optional<Venda> buscarVenda(Long id){
        return vendaRepository.findById(id);
    }

    public Optional<Venda> atualizar(Long id){
        return vendaRepository.findById(id);
    }

    public Venda salvar(Venda venda) {
        return vendaRepository.save(venda);
    }

    public ResponseEntity deletar(Long id) {
        vendaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
