package com.br.zup.projetocontrolefinanceiro.DTOs;

import com.br.zup.projetocontrolefinanceiro.enums.Status;

public class FiltroContaDTO {
    private Status status;

    public FiltroContaDTO() { }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
