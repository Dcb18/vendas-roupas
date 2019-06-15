package br.com.roupas.loja.model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "vendas_produtos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class VendaProduto {

    public VendaProduto(Produto produtos, Venda vendas,  Integer quantidade) {
        this.vendas = vendas;
        this.produtos = produtos;
        this.quantidade = quantidade;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Venda.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Venda vendas;

    @ManyToOne(targetEntity = Produto.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Produto produtos;

    @Column(name = "qtd")
    private Integer quantidade;
}
