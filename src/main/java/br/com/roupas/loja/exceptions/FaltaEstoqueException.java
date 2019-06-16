package br.com.roupas.loja.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INSUFFICIENT_STORAGE, reason = "Não há estoque suficiente do produto")
public class FaltaEstoqueException extends RuntimeException {
}
