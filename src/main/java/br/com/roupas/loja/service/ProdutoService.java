package br.com.roupas.loja.service;

import br.com.roupas.loja.model.Produto;
import br.com.roupas.loja.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
@ComponentScan
public class ProdutoService {

    @Autowired
    private ProdutosRepository repository;


    public void save(Produto produto){
       repository.findById(produto.getId()).ifPresent(produto1 -> produto.setPreco(produto.getPreco().add(produto1.getPreco())));
        repository.save(produto);
    }

    public Page<Produto> findPagable(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Produto findById(Produto produto) {
        return repository.findById(produto.getId()).orElseGet(null);
    }





}
