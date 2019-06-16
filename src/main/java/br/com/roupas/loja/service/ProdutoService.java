package br.com.roupas.loja.service;

import br.com.roupas.loja.exceptions.NotFoundException;
import br.com.roupas.loja.model.Produto;
import br.com.roupas.loja.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProdutoService {

    @Autowired
    private ProdutosRepository repository;


    public void save(Produto produto){
        repository.save(produto);
    }

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public List<Produto> findByCodigoContaining(String codigo) {
        return repository.findByCodigoContaining(codigo);
    }

    public Produto findByCodigo(String codigo) throws NotFoundException {
        return repository.findByCodigo(codigo).orElseThrow(NotFoundException::new);
    }


    public Produto findById(Produto produto) {
        return repository.findById(produto.getId()).orElseGet(null);
    }





}
