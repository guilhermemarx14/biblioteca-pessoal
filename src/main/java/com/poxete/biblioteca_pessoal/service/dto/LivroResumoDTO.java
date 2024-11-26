package com.poxete.biblioteca_pessoal.service.dto;

import com.poxete.biblioteca_pessoal.model.Autor;
import com.poxete.biblioteca_pessoal.model.Livro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static com.poxete.biblioteca_pessoal.utils.Utils.capitalizarPalavras;
import static com.poxete.biblioteca_pessoal.utils.Utils.formatarListaComE;

@Getter
@Setter
@AllArgsConstructor
public class LivroResumoDTO {
    Integer id;
    String titulo;
    List<Autor> autores;
    String classificacao;

    public LivroResumoDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.autores = livro.getAutores();
        this.classificacao = livro.getClassificacao() == null ? "Sem classificação" : "*".repeat(Math.max(0, livro.getClassificacao()));
    }

    public String toString() {
        return capitalizarPalavras(
                "\n{ Id: " + id + " || Titulo: " + titulo + " || Autores: " + formatarListaComE(autores.stream().map(Autor::getNome).toList()) +
                        " || Nota: " + ((classificacao == null) ? "Sem classificação" : classificacao) + " }");
    }
}
