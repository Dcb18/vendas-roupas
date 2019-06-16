package br.com.roupas.loja.repository;

import br.com.roupas.loja.model.Produto;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutosRepository extends JpaRepository<Produto, Long> {

    @Override
    Optional<Produto> findById(Long aLong);

    List<Produto> findByCodigoContaining(String codigo);

    Optional<Produto> findByCodigo(String codigo);
}
