package com.poxete.biblioteca_pessoal.service.dto;

import com.poxete.biblioteca_pessoal.model.Autor;
import com.poxete.biblioteca_pessoal.utils.IgnorarNoCoverage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static com.poxete.biblioteca_pessoal.utils.Utils.capitalizarPalavras;
import static com.poxete.biblioteca_pessoal.utils.Utils.formatarListaComE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@IgnorarNoCoverage
public class LivroResumoDTO {
    Integer id;
    String titulo;
    List<Autor> autores;
    String classificacao;

    public String toString() {
        return capitalizarPalavras(
                "\n{ Id: " + id + " || Titulo: " + titulo + " || Autores: " + formatarListaComE(autores.stream().map(Autor::getNome).toList()) +
                        " || Nota: " + ((classificacao == null) ? "Sem classificação" : classificacao) + " }");
    }
}
