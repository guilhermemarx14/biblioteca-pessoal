package com.poxete.biblioteca_pessoal.controller.dto;

import com.poxete.biblioteca_pessoal.model.Autor;
import com.poxete.biblioteca_pessoal.model.Livro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static com.poxete.biblioteca_pessoal.utils.Utils.formatarListaComE;

@Getter
@Setter
@AllArgsConstructor
public class LivroResumoDTO {
    String titulo;
    List<Autor> autores;

    public LivroResumoDTO(Livro livro) {
        this.titulo = livro.getTitulo();
        this.autores = livro.getAutores();
    }

    public String toString() {
        return "{\n\tTitulo: " + titulo + "\n\tAutores: " + formatarListaComE(autores) + "\n}";
    }
}
