package br.com.roupas.loja.controller;

import br.com.roupas.loja.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan
public class ProdutosController {
    @Autowired
    private ProdutoService service;

    @GetMapping("/produtos/lista")
    public ModelAndView showProducts(@RequestParam(value = "page",required = false) Integer page){
        if(page==null) {
            page = 0;
        }
        ModelAndView mv = new ModelAndView("getProdutos");
        mv.addObject("produtos", service.findPagable(PageRequest.of(page, 10)));

        return mv;

    }


}
