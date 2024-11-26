package com.poxete.biblioteca_pessoal.service.dto;

import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroCompletoDTO {
    String titulo;
    boolean lido;
    Integer anoPublicacao;
    List<String> generos;
    List<String> autores;
    String editora;
    String localizacao;
    Integer quantidade;
    Integer classificacao;
    Date dataLeitura;
    String comentario;
}
