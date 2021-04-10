package com.br.zup.projetocontrolefinanceiro.controllers;

import com.br.zup.projetocontrolefinanceiro.DTOs.CategoriaDTO;
import com.br.zup.projetocontrolefinanceiro.models.Categoria;
import com.br.zup.projetocontrolefinanceiro.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("categorias/")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaDTO registrarCategoria(@RequestBody @Valid CategoriaDTO categoriaDTO){

        Categoria categoria = categoriaDTO.converterCategoriaParaDTO();
        Categoria objetoCategoria = categoriaService.cadastrarCategoria(categoria);

        return CategoriaDTO.converterParaCategoriaDTO(objetoCategoria);
    }

    @GetMapping
    public Iterable<Categoria> listarCategorias(){
        return categoriaService.buscarTodasCategorias();
    }

    @DeleteMapping("{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirCategoria(@PathVariable int id){
        categoriaService.deletarCategoria(id);
    }
}
