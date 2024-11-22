package com.poxete.biblioteca_pessoal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Livro{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull
    String titulo;

    @NotNull
    Integer anoPublicacao;

    @NotNull
    @ManyToMany
    @JoinTable(
            name = "livro_genero",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "genero_id")
    )
    List<Genero> generos;

    @NotNull
    @ManyToMany
    @JoinTable(
            name = "livro_autor",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
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
