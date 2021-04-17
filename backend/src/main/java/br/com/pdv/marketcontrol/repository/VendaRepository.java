package br.com.pdv.marketcontrol.repository;

import br.com.pdv.marketcontrol.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
}
