package com.br.zup.projetocontrolefinanceiro.repositories;

import com.br.zup.projetocontrolefinanceiro.models.Credito;
import org.springframework.data.repository.CrudRepository;

public interface CreditoRepository extends CrudRepository<Credito, Integer> {
    Iterable<Credito> findByCategoriasNome(String nome);
}
