package com.br.zup.projetocontrolefinanceiro.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "creditos")
public class Credito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private double valor;
    private String descricao;
    private LocalDate dataEntrada;

    @ManyToOne()
    private Saldo saldo;

    @ManyToMany()
    private List<Categoria> categorias;

    public Credito() { }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public LocalDate getDataEntrada() { return dataEntrada; }
    public void setDataEntrada(LocalDate dataEntrada) { this.dataEntrada = dataEntrada; }

    public Saldo getSaldo() { return saldo; }
    public void setSaldo(Saldo saldo) { this.saldo = saldo; }

    public List<Categoria> getCategorias() { return categorias; }
    public void setCategorias(List<Categoria> categorias) { this.categorias = categorias; }
}

