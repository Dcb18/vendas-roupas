package br.com.roupas.loja.controller;

import br.com.roupas.loja.exceptions.FaltaEstoqueException;
import br.com.roupas.loja.model.Produto;
import br.com.roupas.loja.model.enuns.Sexo;
import br.com.roupas.loja.model.request.ProdutoFilter;
import br.com.roupas.loja.model.request.ProdutoRequest;
import br.com.roupas.loja.model.request.VendaProdutoRequest;
import br.com.roupas.loja.repository.ProdutosRepository;
import br.com.roupas.loja.service.ProdutoService;
import br.com.roupas.loja.service.VendaProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/compra")
public class VendaProdutosController {
    @Autowired
    private VendaProdutoService service;

    private VendaProdutoRequest vendaProdutoRequest;

    @GetMapping("/carrinho")
    public ModelAndView comprar() {
        if(vendaProdutoRequest==null) {
            vendaProdutoRequest = new VendaProdutoRequest();
        }
        ModelAndView mv = new ModelAndView("vendaProdutos");
        mv.addObject("vendaProduto",  vendaProdutoRequest);
        mv.addObject("produtoRequest", new ProdutoRequest());

        return mv;
    }

    @PostMapping("/adicionar")
    public ModelAndView adicionar(ProdutoRequest produto) throws FaltaEstoqueException {
        vendaProdutoRequest = service.adicionarCarrionho(produto, vendaProdutoRequest);
        return comprar();
    }

    @GetMapping("/remover/{codigo}")
    public ModelAndView remover(@PathVariable("codigo") String codigo) throws FaltaEstoqueException {
        vendaProdutoRequest = service.retirar(codigo, vendaProdutoRequest);
        return comprar();
    }





}
