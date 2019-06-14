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
public class Vendas {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "vendedor")
    @NotBlank
    private String vendedor;

    @Column(name = "cliente")
    @NotBlank
    private String cliente;

    @Column(name = "data_venda")
    @NotNull
    private Date dataVenda;

    @PrePersist
    private void SetOfDataVenda() {
        dataVenda = new Date();
    }



}
