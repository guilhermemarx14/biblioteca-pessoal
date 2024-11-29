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
    String titulo;
    List<Autor> autores;
    Integer classificacao;

    private String decodeClassificacao() {
        return switch (classificacao) {
            case 1 -> "achei muito ruim";
            case 2 -> "achei ruim";
            case 3 -> "achei mediano";
            case 4 -> "gostei";
            case 5 -> "gostei muito";
            default -> "nao lembro se gostei";
        };
    }

    public String toString() {
        return capitalizarPalavras(
                " " + titulo + " de " + formatarListaComE(autores.stream().map(Autor::getNome).toList()) + " (" + decodeClassificacao() + ")");
    }
}
