package com.br.zup.projetocontrolefinanceiro.services;

import com.br.zup.projetocontrolefinanceiro.DTOs.FiltroCategoriaDTO;
import com.br.zup.projetocontrolefinanceiro.models.Categoria;
import com.br.zup.projetocontrolefinanceiro.models.Credito;
import com.br.zup.projetocontrolefinanceiro.repositories.CreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreditoService {
    @Autowired
    CreditoRepository creditoRepository;

    @Autowired
    SaldoService saldoService;

    @Autowired
    CategoriaService categoriaService;

    public Credito cadastrarCredito(Credito credito) {

        credito.setDataEntrada(LocalDate.now());
        credito.setCategorias(adicionarCategoria(credito.getCategorias()));
        credito.setSaldo(saldoService.pesquisarSaldoPeloCPF(credito.getSaldo().getCpf()));
        Credito novoCredito = creditoRepository.save(credito);

        saldoService.creditarSaldo(novoCredito);

        return novoCredito;
    }

    public Iterable<Credito> pesquisarTodosCreditos(){
        return creditoRepository.findAll();
    }

    private List<Categoria> adicionarCategoria(List<Categoria> categorias) {
        List<Categoria> listaCategoria = new ArrayList<>();

        for (Categoria categoria : categorias) {
            if (categoria.getId() == null) {
                listaCategoria.add(categoriaService.cadastrarCategoria(categoria));
            } else {
                listaCategoria.add(categoriaService.buscarCategoriaPeloId(categoria.getId()));
            }
        }

        return listaCategoria;
    }

    public Iterable<Credito> pesquisarTodosCreditosPorCategoria(FiltroCategoriaDTO filtro){
        if (filtro == null){
            return creditoRepository.findAll();
        }

        return creditoRepository.findByCategoriasNome(filtro.getNome());
    }
}
