package com.poxete.biblioteca_pessoal.service.dto;

import com.poxete.biblioteca_pessoal.utils.IgnorarNoCoverage;
import lombok.*;

import java.sql.Date;
import java.util.List;

import static com.poxete.biblioteca_pessoal.utils.Utils.capitalizarPalavras;
import static com.poxete.biblioteca_pessoal.utils.Utils.formatarListaComE;

@Getter
@Setter
@Builder
@IgnorarNoCoverage
@AllArgsConstructor
@NoArgsConstructor
public class LivroCompletoDTO {
    Integer id;
    String titulo;
    Boolean lido;
    Integer anoPublicacao;
    List<String> generos;
    List<String> autores;
    String editora;
    String localizacao;
    Integer quantidade;
    Integer classificacao;
    Date dataLeitura;
    String comentario;
    Boolean favorito;
    String dadosWikipedia;

    public String getAutoresComoString() {
        return capitalizarPalavras(formatarListaComE(autores));
    }

    public String getGenerosComoString() {
        return capitalizarPalavras(formatarListaComE(generos));
    }


    public String getClassificacaoComoString() {
        return "★ ".repeat(Math.max(0, this.classificacao));
    }


}
