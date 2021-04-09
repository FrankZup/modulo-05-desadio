package com.br.zup.projetocontrolefinanceiro.exceptions;

public class ContaStatusException extends ExcecaoBasica {
    public ContaStatusException(){
        super("O status da conta sรณ pode estar como AGUARDANDO ou ATRASADO", 422, "status", "Unprocessable Entity");
    }
}
