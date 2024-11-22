package com.poxete.biblioteca_pessoal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull
    String titulo;

    @NotNull
    Boolean lido;

    @NotNull
    Integer anoPublicacao;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "livro_genero", joinColumns = @JoinColumn(name = "livro_id"), inverseJoinColumns = @JoinColumn(name = "genero_id"))
    List<Genero> generos;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "livro_autor", joinColumns = @JoinColumn(name = "livro_id"), inverseJoinColumns = @JoinColumn(name = "autor_id"))
    List<Autor> autores;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "editora_id")
    Editora editora;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "localizacao_id")
    Localizacao localizacao;

    @NotNull
    Integer quantidade;


}
