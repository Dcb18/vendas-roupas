package br.com.roupas.loja.controller;

import br.com.roupas.loja.model.Produto;
import br.com.roupas.loja.model.enuns.Sexo;
import br.com.roupas.loja.model.request.ProdutoFilter;
import br.com.roupas.loja.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {
    @Autowired
    private ProdutoService service;

    @GetMapping("/lista")
    public ModelAndView findAll(@RequestParam(value = "codigo",required = false) String codigo){
        List<Produto> produtos;
        if(codigo == null) {
            produtos = service.findAll();
        } else {
            produtos = service.findByCodigoContaining(codigo);
        }

        ModelAndView mv = new ModelAndView("getProdutos");
        mv.addObject("produtos", produtos);
        mv.addObject("filter", new ProdutoFilter());
        return mv;

    }

    @GetMapping("/add")
    public ModelAndView add(Produto produto) {

        ModelAndView mv = new ModelAndView("postProdutos");
        Map<String, Object> att = new HashMap<>();
        att.put("produto", produto);
        att.put("sexo", Sexo.values());
        mv.addAllObjects(att);
        return mv;
    }
    @PostMapping("/save")
    public ModelAndView save(Produto produto) {
        service.save(produto);
        return findAll(null);
    }

    @GetMapping("/edit/{codigo}")
    public ModelAndView edit(@PathVariable("codigo") String codigo) {

        return add(service.findByCodigo(codigo));
    }


}
