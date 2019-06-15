package br.com.roupas.loja.model.request;

import br.com.roupas.loja.model.Produto;
import br.com.roupas.loja.model.Venda;
import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class VendaProdutoRequest {


    private Venda vendas;
    private List<Produto> produtos;
    private Integer qtd;
}
