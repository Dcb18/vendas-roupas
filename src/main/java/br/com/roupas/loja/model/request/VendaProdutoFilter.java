package br.com.roupas.loja.model.request;

import lombok.*;
import org.springframework.data.domain.Pageable;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class VendaProdutoFilter {


    private String vendedor;

    private String cliente;


    private Date dataVenda;

    private Boolean pago;

    private Pageable pageable;
}
