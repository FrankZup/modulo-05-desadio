package com.br.zup.projetocontrolefinanceiro.exceptions;

import java.util.List;

public class RespostaErro {
    private String tipoErro;
    private int codigo;
    private String status;
    private List<ObjetoErro> objetosDeErro;

    public RespostaErro(String tipoErro, int codigo, String status, List<ObjetoErro> objetosDeErro) {
        this.tipoErro = tipoErro;
        this.codigo = codigo;
        this.status = status;
        this.objetosDeErro = objetosDeErro;
    }

    public RespostaErro() { }

    public String getTipoErro() { return tipoErro; }
    public void setTipoErro(String tipoErro) { this.tipoErro = tipoErro; }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<ObjetoErro> getObjetosDeErro() { return objetosDeErro; }
    public void setObjetosDeErro(List<ObjetoErro> objetosDeErro) {
        this.objetosDeErro = objetosDeErro;
    }
}
