package com.poxete.biblioteca_pessoal.service.dto;

import com.poxete.biblioteca_pessoal.utils.IgnorarNoCoverage;
import com.poxete.biblioteca_pessoal.utils.Utils;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

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
    String generos;
    String autores;
    String editora;
    String localizacao;
    Integer quantidade;
    Integer classificacao;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    LocalDate dataLeitura;

    String comentario;
    Boolean favorito;
    String sinopse;

    public String getAutoresComoString() {
        return capitalizarPalavras(formatarListaComE(Utils.obterItensDeListaAPartirDeString(autores)));
    }

    public String getGenerosComoString() {
        return capitalizarPalavras(formatarListaComE(Utils.obterItensDeListaAPartirDeString(generos)));
    }


    public String getClassificacaoComoString() {
        if (this.classificacao == null || this.classificacao == 0)
            return "Sem classificação";
        return "★ ".repeat(Math.max(0, this.classificacao));
    }


}
