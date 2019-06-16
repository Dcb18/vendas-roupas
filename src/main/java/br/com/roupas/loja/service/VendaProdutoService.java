package br.com.roupas.loja.service;

import br.com.roupas.loja.exceptions.FaltaEstoqueException;
import br.com.roupas.loja.model.Produto;
import br.com.roupas.loja.model.ProdutoCarrinho;
import br.com.roupas.loja.model.VendaProduto;
import br.com.roupas.loja.model.request.ProdutoRequest;
import br.com.roupas.loja.model.request.VendaProdutoFilter;
import br.com.roupas.loja.model.request.VendaProdutoRequest;
import br.com.roupas.loja.repository.VendasProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendaProdutoService {

    @Autowired
    private VendasProdutosRepository repository;

    @Autowired
    private VendaService service;

    @Autowired
    private ProdutoService produtoService;

    public Page<VendasProdutosRepository> findByFilter(VendaProdutoFilter request) {
        Page page = repository.findAll(new Specification<VendaProduto>() {
            @Override
            public Predicate toPredicate(Root<VendaProduto> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(request.getCliente()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("cliente"), request.getCliente())));
                }
                if(request.getDataVenda()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("dataVenda"), request.getDataVenda())));
                }
                if(request.getPago()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("pago"), request.getPago())));
                }
                if(request.getVendedor()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("vendedor"), request.getVendedor())));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, request.getPageable());

        return page;
    }

    public void venda(VendaProdutoRequest vpr) {
      //  vpr.getProdutos().stream().map(produto1 -> repository.save(new VendaProduto(produto1, vpr.getVenda(), vpr.getQtd())));
    }

    public VendaProdutoRequest adicionarCarrionho(ProdutoRequest produto, VendaProdutoRequest vendaProdutoRequest){
        ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho();
       Produto produtoReal = produtoService.findByCodigo(produto.getCodigo());
        if(produto.getQuantidade().compareTo(produtoReal.getQuantidade()) == 1) {
            throw new FaltaEstoqueException();
        }

        vendaProdutoRequest.adicionarProdutos(produtoCarrinho.builder()
                .codigo(produtoReal.getCodigo())
                .desc(produtoReal.getDesc())
                .preco(produtoReal.getPreco().multiply(new BigDecimal(produto.getQuantidade())))
                .quantidade(produto.getQuantidade())
                .sexo(produtoReal.getSexo())
                .build());
        vendaProdutoRequest.setValorTotal(vendaProdutoRequest.getValorTotal().add(produtoReal.getPreco().multiply(new BigDecimal(produto .getQuantidade()))));
        vendaProdutoRequest.setQtd(vendaProdutoRequest.getQtd()+produto.getQuantidade());
        return vendaProdutoRequest;
    }

    public VendaProdutoRequest retirar(String codigo, VendaProdutoRequest vendaProdutoRequest) {
        vendaProdutoRequest.setProdutos(vendaProdutoRequest.getProdutos().stream().filter(x -> !x.getCodigo().equals(codigo)).collect(Collectors.toList()));
        return vendaProdutoRequest;
    }
}
