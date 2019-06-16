package br.com.roupas.loja.model.request;

import lombok.Data;

@Data
public class ProdutoRequest {
    private String codigo;
    private Integer quantidade;
}
