package com.br.zup.projetocontrolefinanceiro.repositories;

import com.br.zup.projetocontrolefinanceiro.enums.Status;
import com.br.zup.projetocontrolefinanceiro.models.Conta;
import org.springframework.data.repository.CrudRepository;

public interface ContaRepository extends CrudRepository<Conta, Integer> {
    Iterable<Conta> findByStatus(Status status);
}

