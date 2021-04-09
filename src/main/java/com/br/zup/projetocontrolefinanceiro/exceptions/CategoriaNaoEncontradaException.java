package com.br.zup.projetocontrolefinanceiro.exceptions;

public class CategoriaNaoEncontradaException extends ExcecaoBasica {
    public CategoriaNaoEncontradaException(){
        super("Categoria não encontrada!", 404, "id", "Not Found");
    }
}
