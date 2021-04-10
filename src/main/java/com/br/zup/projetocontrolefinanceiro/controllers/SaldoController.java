package com.br.zup.projetocontrolefinanceiro.controllers;

import com.br.zup.projetocontrolefinanceiro.DTOs.SaldoDTO;
import com.br.zup.projetocontrolefinanceiro.models.Saldo;
import com.br.zup.projetocontrolefinanceiro.services.SaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("saldos/")
public class SaldoController {
    @Autowired
    SaldoService saldoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaldoDTO registrarSaldo(@RequestBody @Valid SaldoDTO saldoDTO){
        Saldo saldo = saldoDTO.converterDTOParaSaldo();
        Saldo objetoSaldo = saldoService.cadastrarSaldo(saldo);

        return SaldoDTO.converterSaldoParaDTO(objetoSaldo);
    }

    @GetMapping
    public Iterable<Saldo> listarSaldo(){
        return saldoService.listarSaldo();
    }
}
