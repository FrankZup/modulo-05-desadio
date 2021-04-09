package com.br.zup.projetocontrolefinanceiro.DTOs;

import com.br.zup.projetocontrolefinanceiro.models.Categoria;
import com.br.zup.projetocontrolefinanceiro.models.Credito;
import com.br.zup.projetocontrolefinanceiro.models.Saldo;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CadastrarCreditoDTO {
    private Integer id;

    @NotBlank
    private String descricao;

    @Positive
    private double valor;

    @NotBlank
    @CPF(message = "CPF inválido")
    private String cpf;

    private List<Categoria> categorias;

    private LocalDate dataEntrada;

    public CadastrarCreditoDTO() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public List<Categoria> getCategorias() { return categorias; }
    public void setCategorias(List<Categoria> categorias) { this.categorias = categorias; }

    public LocalDate getDataEntrada() { return dataEntrada; }
    public void setDataEntrada(LocalDate dataEntrada) { this.dataEntrada = dataEntrada; }

    public Credito converterCreditoParaDTO() {
        Credito credito = new Credito();

        credito.setDescricao(this.descricao);
        credito.setValor(this.valor);

        Saldo saldo = new Saldo();

        saldo.setCpf(this.cpf);
        credito.setSaldo(saldo);

        credito.setCategorias(this.categorias);
        credito.setDataEntrada(LocalDate.now());

        return credito;
    }

    public static CadastrarCreditoDTO converterDTOParaCredito(Credito credito) {
        CadastrarCreditoDTO creditoDTO = new CadastrarCreditoDTO();

        creditoDTO.setId(credito.getId());
        creditoDTO.setDescricao(credito.getDescricao());
        creditoDTO.setValor(credito.getValor());
        creditoDTO.setCpf(credito.getSaldo().getCpf());
        creditoDTO.setCategorias(credito.getCategorias());
        creditoDTO.setDataEntrada(credito.getDataEntrada());

        return creditoDTO;

    }

    public static Iterable<CadastrarCreditoDTO> converterListaCreditoDTO(Iterable<Credito> creditos) {
        List<CadastrarCreditoDTO> visualizarCreditoDTOS = new ArrayList<>();
        for (Credito credito : creditos ) {
            visualizarCreditoDTOS.add(CadastrarCreditoDTO.converterDTOParaCredito(credito));
        }
        return visualizarCreditoDTOS;
    }
}
