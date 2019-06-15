package br.com.roupas.loja.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "vendas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Venda {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vendedor")
    @NotBlank
    private String vendedor;

    @Column(name = "cliente")
    @NotBlank
    private String cliente;

    @Column(name = "data_venda")
    private Date dataVenda;
//
//    @ManyToOne
//    @JoinColumn(name = "venda_id")
//    private VendaProduto vendasProduto;

    @Column(name = "pago")
    private Boolean pago;


    @PrePersist
    private void SetOfDataVenda() {
        dataVenda = new Date();
    }



}
