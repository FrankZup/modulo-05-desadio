package com.br.zup.projetocontrolefinanceiro.services;

import com.br.zup.projetocontrolefinanceiro.exceptions.SaldoNaoEncontradoException;
import com.br.zup.projetocontrolefinanceiro.models.Conta;
import com.br.zup.projetocontrolefinanceiro.models.Credito;
import com.br.zup.projetocontrolefinanceiro.models.Saldo;
import com.br.zup.projetocontrolefinanceiro.repositories.SaldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaldoService {
    @Autowired
    SaldoRepository saldoRepository;

    @Autowired
    ContaService contaService;

    public Saldo cadastrarSaldo(Saldo saldo) {

        return saldoRepository.save(saldo);
    }

    public Iterable<Saldo> listarSaldo() {
        return saldoRepository.findAll();
    }

    public Saldo pesquisarSaldoPeloCPF(String cpf) {
        Optional<Saldo> saldoPesquisado = saldoRepository.findById(cpf);

        if(saldoPesquisado.isPresent() ){
            return saldoPesquisado.get();
        }

        throw new SaldoNaoEncontradoException();
    }


    public void creditarSaldo(Credito credito){
        Saldo saldo = pesquisarSaldoPeloCPF(credito.getSaldo().getCpf());

        double valorAtualizado = saldo.getValor() + credito.getValor();

        saldo.setValor(valorAtualizado);
        cadastrarSaldo(saldo);
    }

    public boolean debitarSaldo(Conta conta){

        Saldo saldo = pesquisarSaldoPeloCPF(conta.getSaldo().getCpf());

        double limiteDebito = saldo.getValor() + saldo.getLimite();

        if (limiteDebito > conta.getValor()){
            saldo.setValor(saldo.getValor() - conta.getValor());
        } else {
            return false;
        }

        cadastrarSaldo(saldo);

        return true;
    }
}
