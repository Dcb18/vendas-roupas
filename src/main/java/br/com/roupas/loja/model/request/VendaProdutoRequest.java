package br.com.roupas.loja.model.request;

import br.com.roupas.loja.model.ProdutoCarrinho;
import br.com.roupas.loja.model.Venda;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class VendaProdutoRequest {


    private Venda venda;
    private List<ProdutoCarrinho> produtos = new ArrayList<>();
    private Integer qtd = 0;
    private BigDecimal valorTotal = BigDecimal.ZERO;

    public void adicionarProdutos(ProdutoCarrinho produto) {

        if (produtos.isEmpty()) {
            produtos.add(produto);
        } else {
            var achou = false;
            for (ProdutoCarrinho p : produtos) {
                if (p.getCodigo().equals(produto.getCodigo())) {
                    p.setQuantidade(p.getQuantidade() + produto.getQuantidade());
                    p.setPreco(p.getPreco().add(produto.getPreco()));
                    achou = true;
                }
            }

            if (!achou) {
                produtos.add(produto);
            }
        }


    }
}
