package com.br.zup.projetocontrolefinanceiro.exceptions;

public class SaldoNaoEncontradoException extends ExcecaoBasica {
    public SaldoNaoEncontradoException(){
        super("Saldo não encontrado!", 404, "cpf", "Not Found");
    }
}
