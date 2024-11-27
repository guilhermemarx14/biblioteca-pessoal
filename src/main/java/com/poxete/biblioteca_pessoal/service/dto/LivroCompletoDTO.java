package com.poxete.biblioteca_pessoal.service.dto;

import com.poxete.biblioteca_pessoal.utils.IgnorarNoCoverage;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Builder
@IgnorarNoCoverage
@AllArgsConstructor
@NoArgsConstructor
public class LivroCompletoDTO {
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
}
