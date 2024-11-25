package com.poxete.biblioteca_pessoal.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
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
}
