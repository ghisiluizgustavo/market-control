package br.com.pdv.marketcontrol.repository;

import br.com.pdv.marketcontrol.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findByCodBarras(String codBarras);
}
