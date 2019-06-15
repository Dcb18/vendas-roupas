package br.com.roupas.loja.repository;

import br.com.roupas.loja.model.Venda;
import br.com.roupas.loja.model.VendaProduto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendasRepository extends JpaRepository<Venda, Long> {


}
