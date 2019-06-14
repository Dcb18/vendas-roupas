package br.com.roupas.loja.model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "vendas_produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class VendasProduto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    @JoinColumn(name = "vendas_id")
    private List<Vendas> vendas;

    @OneToMany
    @JoinColumn(name = "produtos_id")
    private List<Produtos> produtos;

    @Column(name = "qtd")
    private BigDecimal quantidade;
}
