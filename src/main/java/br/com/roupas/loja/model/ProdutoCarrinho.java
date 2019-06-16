package br.com.roupas.loja.model;

import br.com.roupas.loja.model.enuns.Sexo;
import lombok.*;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class ProdutoCarrinho {

    private String codigo;
    private String desc;

    private Sexo sexo;
    private BigDecimal preco;
    private Integer quantidade;
}
