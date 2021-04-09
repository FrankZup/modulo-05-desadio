package com.br.zup.projetocontrolefinanceiro.exceptions;

public class SaldoInsuficienteException extends ExcecaoBasica {
    public SaldoInsuficienteException(){
        super("Saldo insuficiente", 422, "valor, limite", "Unprocessable Entity");
    }
}
