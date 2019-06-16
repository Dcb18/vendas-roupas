package br.com.roupas.loja.model;

import br.com.roupas.loja.model.enuns.Sexo;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Produto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", nullable = false)
    @NotBlank
    private String codigo;

    @Column(name = "desc", nullable = false)
    @NotBlank
    private String desc;

    @Column(name = "sexo", nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "preco", nullable = false)
    @NotNull
    private BigDecimal preco;

    @Column(name = "quantidade", nullable = false)
    @NotNull
    private Integer quantidade;




}
