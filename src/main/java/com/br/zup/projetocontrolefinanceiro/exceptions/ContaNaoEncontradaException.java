package com.br.zup.projetocontrolefinanceiro.exceptions;

public class ContaNaoEncontradaException extends ExcecaoBasica {
    public ContaNaoEncontradaException(){
        super("Conta não encontrada!", 404, "id", "Not Found");
    }
}
