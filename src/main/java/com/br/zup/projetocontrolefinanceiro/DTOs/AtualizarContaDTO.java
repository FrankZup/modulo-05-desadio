package com.br.zup.projetocontrolefinanceiro.DTOs;

import com.br.zup.projetocontrolefinanceiro.enums.Status;
import com.br.zup.projetocontrolefinanceiro.models.Conta;

public class AtualizarContaDTO {
    private Integer id;
    private double valor;
    private String descricao;
    private Status status;
    private String cpf;

    public AtualizarContaDTO() {}


    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public Conta converterAtualizarContaParaDTO() {
        Conta conta = new Conta();

        conta.setId(this.id);
        conta.setStatus(this.status);

        return conta;
    }

    public static AtualizarContaDTO converterDTOParaAtualizarConta(Conta conta) {
        AtualizarContaDTO atualizarContaDTO = new AtualizarContaDTO();

        atualizarContaDTO.setCpf(conta.getSaldo().getCpf());
        atualizarContaDTO.setId(conta.getId());
        atualizarContaDTO.setDescricao(conta.getDescricao());
        atualizarContaDTO.setValor(conta.getValor());
        atualizarContaDTO.setStatus(Status.PAGO);

        return atualizarContaDTO;
    }
}
