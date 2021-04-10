package com.br.zup.projetocontrolefinanceiro.controllers;

import com.br.zup.projetocontrolefinanceiro.DTOs.AtualizarContaDTO;
import com.br.zup.projetocontrolefinanceiro.DTOs.CadastrarContaDTO;
import com.br.zup.projetocontrolefinanceiro.DTOs.FiltroContaDTO;
import com.br.zup.projetocontrolefinanceiro.models.Conta;
import com.br.zup.projetocontrolefinanceiro.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("contas/")
public class ContaController {
    @Autowired
    ContaService contaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CadastrarContaDTO registrarConta(@RequestBody @Valid CadastrarContaDTO contaDTO) {

        Conta conta = contaService.cadastrarConta(contaDTO.converterContaParaDTO());
        return CadastrarContaDTO.converterDTOParaConta(conta);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AtualizarContaDTO atualizarConta(@RequestBody @Valid AtualizarContaDTO contaDTO) {

        Conta contaAtualizada = contaService.atualizarConta(contaDTO.converterAtualizarContaParaDTO());
        return AtualizarContaDTO.converterDTOParaAtualizarConta(contaAtualizada);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<CadastrarContaDTO> pesquisarContaPorStatus(@ModelAttribute FiltroContaDTO filtro) {
        return CadastrarContaDTO.converterListaContaDTO(contaService.pesquisarContaPorStatus(filtro));
    }
}
