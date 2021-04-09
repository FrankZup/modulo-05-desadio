package com.br.zup.projetocontrolefinanceiro.DTOs;

import com.br.zup.projetocontrolefinanceiro.models.Saldo;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Positive;

public class SaldoDTO {
    @CPF(message = "CPF inválido!")
    private String cpf;

    @Positive
    private double valor;

    @Positive
    private double limite;

    public SaldoDTO() {}

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public double getLimite() { return limite; }
    public void setLimite(double limite) { this.limite = limite; }

    public Saldo converterDTOParaSaldo() {
        Saldo saldo = new Saldo();

        saldo.setCpf(this.cpf);
        saldo.setValor(this.valor);
        saldo.setLimite(this.limite);

        return saldo;
    }

    public static SaldoDTO converterSaldoParaDTO(Saldo saldo){
        SaldoDTO saldoDTO = new SaldoDTO();

        saldoDTO.setCpf(saldo.getCpf());
        saldoDTO.setValor(saldo.getValor());
        saldoDTO.setLimite(saldo.getValor());

        return saldoDTO;
    }
}
