package com.br.zup.projetocontrolefinanceiro.models;

import com.br.zup.projetocontrolefinanceiro.enums.Status;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double valor;
    private String descricao;
    private LocalDate dataEntrada;
    private LocalDate dataVencimento;
    private Status status;

    @ManyToOne()
    private Saldo saldo;

    public Conta() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public LocalDate getDataEntrada() { return dataEntrada; }
    public void setDataEntrada(LocalDate dataEntrada) { this.dataEntrada = dataEntrada; }

    public LocalDate getDataVencimento() { return dataVencimento; }
    public void setDataVencimento(LocalDate dataVencimento) { this.dataVencimento = dataVencimento; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public Saldo getSaldo() { return saldo; }
    public void setSaldo(Saldo saldo) { this.saldo = saldo; }


}
