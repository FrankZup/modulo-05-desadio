package com.br.zup.projetocontrolefinanceiro.DTOs;

import com.br.zup.projetocontrolefinanceiro.enums.Status;
import com.br.zup.projetocontrolefinanceiro.models.Conta;
import com.br.zup.projetocontrolefinanceiro.models.Saldo;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CadastrarContaDTO {
    private Integer id;

    @NotBlank
    private String descricao;

    @Positive
    private double valor;

    private LocalDate dataEntrada;
    private LocalDate dataVencimento;

    @NotBlank
    @CPF(message = "CPF inválido")
    private String cpf;

    private Status status;

    public CadastrarContaDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Conta converterContaParaDTO(){
        Conta conta = new Conta();

        conta.setId(this.id);
        conta.setDescricao(this.descricao);
        conta.setValor(this.valor);

        conta.setDataEntrada(LocalDate.now());
        conta.setDataVencimento(this.dataVencimento);

        Saldo saldo = new Saldo();
        saldo.setCpf(this.cpf);

        conta.setSaldo(saldo);

        conta.setStatus(this.status);
        return conta;
    }

    public static CadastrarContaDTO converterDTOParaConta(Conta conta) {
        CadastrarContaDTO cadastrarContaDTO = new CadastrarContaDTO();

        cadastrarContaDTO.setId(conta.getId());
        cadastrarContaDTO.setDescricao(conta.getDescricao());
        cadastrarContaDTO.setValor(conta.getValor());

        cadastrarContaDTO.setDataEntrada(conta.getDataEntrada());
        cadastrarContaDTO.setDataVencimento(conta.getDataVencimento());

        cadastrarContaDTO.setCpf(conta.getSaldo().getCpf());

        cadastrarContaDTO.setStatus(conta.getStatus());

        return cadastrarContaDTO;
    }

    public static Iterable<CadastrarContaDTO> converterListaContaDTO(Iterable<Conta> contas) {
        List<CadastrarContaDTO> visualizarContaDTOS = new ArrayList<>();
        for (Conta conta : contas ) {
            visualizarContaDTOS.add(CadastrarContaDTO.converterDTOParaConta(conta));
        }
        return visualizarContaDTOS;
    }
}
