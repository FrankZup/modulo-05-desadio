package com.br.zup.projetocontrolefinanceiro.services;

import com.br.zup.projetocontrolefinanceiro.DTOs.FiltroContaDTO;
import com.br.zup.projetocontrolefinanceiro.enums.Status;
import com.br.zup.projetocontrolefinanceiro.exceptions.ContaNaoEncontradaException;
import com.br.zup.projetocontrolefinanceiro.exceptions.ContaStatusException;
import com.br.zup.projetocontrolefinanceiro.models.Conta;
import com.br.zup.projetocontrolefinanceiro.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContaService {
    @Autowired
    ContaRepository contaRepository;
    @Autowired
    SaldoService saldoService;

    public Conta cadastrarConta(Conta conta) {

        verificarStatusDaConta(conta);
        conta.setSaldo(saldoService.pesquisarSaldoPeloCPF(conta.getSaldo().getCpf()));

        return contaRepository.save(conta);
    }

    private void verificarStatusDaConta(Conta conta) {
        if (conta.getStatus().equals(Status.PAGO)){
            throw new ContaStatusException();
        }
    }

    public Conta atualizarConta(Conta conta) {

        Conta contaAtual = buscarContaPeloId(conta.getId());

        if (conta.getStatus() == Status.PAGO){
            if (saldoService.debitarSaldo(contaAtual)){
                contaAtual.setStatus(conta.getStatus());
                return contaRepository.save(contaAtual);
            }
        }

        return contaAtual;
    }

    public Conta buscarContaPeloId(int id) {
        Optional<Conta> contaPesquisada = contaRepository.findById(id);

        if (contaPesquisada.isPresent()) {
            return contaPesquisada.get();
        }

        throw new ContaNaoEncontradaException();
    }

    public Iterable<Conta> pesquisarContaPorStatus(FiltroContaDTO filtro) {
        if (filtro == null) {
            return contaRepository.findAll();
        }

        return contaRepository.findByStatus(filtro.getStatus());
    }
}