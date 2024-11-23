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
    String classificacao;

    public LivroResumoDTO(Livro livro) {
        this.titulo = livro.getTitulo();
        this.autores = livro.getAutores();
        this.classificacao = livro.getClassificacao() == 0 ? "Sem classificação" : "*".repeat(Math.max(0, livro.getClassificacao()));
    }

    public String toString() {
        return "\n{\n\tTitulo: " + titulo + "\n\tAutores: " + formatarListaComE(autores) + "\n\tNota: " + classificacao + "\n}";
    }
}
