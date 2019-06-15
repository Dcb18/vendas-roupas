package br.com.roupas.loja.service;

import br.com.roupas.loja.model.Venda;
import br.com.roupas.loja.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

    @Autowired
    private VendasRepository repository;


    public void save(Venda venda) {
        repository.save(venda);
    }


}
