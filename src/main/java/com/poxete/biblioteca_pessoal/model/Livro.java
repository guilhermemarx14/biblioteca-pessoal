package com.poxete.biblioteca_pessoal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@Entity
@ToString
@NoArgsConstructor
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
    Set<Genero> generos;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "editora_id")
    Editora editora;

    @NotNull
    Integer quantidade;



}
