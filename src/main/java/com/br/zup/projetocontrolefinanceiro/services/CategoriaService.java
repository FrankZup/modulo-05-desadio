package com.br.zup.projetocontrolefinanceiro.services;

import com.br.zup.projetocontrolefinanceiro.exceptions.CategoriaNaoEncontradaException;
import com.br.zup.projetocontrolefinanceiro.models.Categoria;
import com.br.zup.projetocontrolefinanceiro.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria cadastrarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Iterable<Categoria> buscarTodasCategorias(){
        return categoriaRepository.findAll();
    }


    public Categoria buscarCategoriaPeloId(int id){
        Optional<Categoria> categoriaPesquisada = categoriaRepository.findById(id);

        if( categoriaPesquisada.isPresent() ){
            return categoriaPesquisada.get();
        }

        throw new CategoriaNaoEncontradaException();
    }

    public void deletarCategoria(int id){
        categoriaRepository.deleteById(id);
    }
}
