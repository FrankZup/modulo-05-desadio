package com.br.zup.projetocontrolefinanceiro.DTOs;

import com.br.zup.projetocontrolefinanceiro.models.Categoria;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDTO {
    private Integer id;

    @NotBlank
    private String nome;

    public CategoriaDTO() { }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public static CategoriaDTO converterParaCategoriaDTO(Categoria categoria){
        CategoriaDTO categoriaDTO = new CategoriaDTO();

        categoriaDTO.setId(categoria.getId());
        categoriaDTO.setNome(categoria.getNome());

        return categoriaDTO;
    }

    public Categoria converterCategoriaParaDTO(){
        Categoria categoria = new Categoria();

        categoria.setId(this.id);
        categoria.setNome(this.nome);

        return categoria;
    }

    public static Iterable<CategoriaDTO> converterIterableCategoriaParaDTO(Iterable<Categoria> categorias){
        List<CategoriaDTO> categoriaDTOS = new ArrayList<>();

        for (Categoria objetoCategoria : categorias){
            categoriaDTOS.add(CategoriaDTO.converterParaCategoriaDTO(objetoCategoria));
        }

        return categoriaDTOS;
    }
}
