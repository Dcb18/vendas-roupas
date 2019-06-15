package br.com.roupas.loja.repository;


import br.com.roupas.loja.model.VendaProduto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface VendasProdutosRepository extends JpaRepository<VendaProduto, Long> , JpaSpecificationExecutor<VendaProduto> {

    @Override
    Optional<VendaProduto> findById(Long aLong);


}
