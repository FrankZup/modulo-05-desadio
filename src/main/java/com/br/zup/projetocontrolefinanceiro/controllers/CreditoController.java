package com.br.zup.projetocontrolefinanceiro.controllers;

import com.br.zup.projetocontrolefinanceiro.DTOs.CadastrarCreditoDTO;
import com.br.zup.projetocontrolefinanceiro.DTOs.FiltroCategoriaDTO;
import com.br.zup.projetocontrolefinanceiro.models.Credito;
import com.br.zup.projetocontrolefinanceiro.services.CreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("creditos/")
public class CreditoController {
    @Autowired
    CreditoService creditoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CadastrarCreditoDTO registrarCredito(@RequestBody @Valid CadastrarCreditoDTO creditoDTO) {

        Credito credito = creditoService.cadastrarCredito(creditoDTO.converterCreditoParaDTO());
        return CadastrarCreditoDTO.converterDTOParaCredito(credito);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<CadastrarCreditoDTO> visualizarTodosCreditos() {
        return CadastrarCreditoDTO.converterListaCreditoDTO(creditoService.pesquisarTodosCreditos());
    }

    @GetMapping("categorias")
    public Iterable<CadastrarCreditoDTO> listarTodosCreditosPorCategoria(@ModelAttribute FiltroCategoriaDTO filtro ){
        return CadastrarCreditoDTO.converterListaCreditoDTO(creditoService.pesquisarTodosCreditosPorCategoria(filtro));
    }
}
