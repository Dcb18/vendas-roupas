package br.com.roupas.loja.model.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Sexo {

    M('M', "Masculino"),
    F('F', "Feminino"),
    U('U', "Unisex");

    private char charValue;
    private String label;
}
