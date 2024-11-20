package com.poxete.biblioteca_pessoal.model;

import jakarta.persistence.*;
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

    String titulo;
    Integer anoPublicacao;
    @ManyToMany
    @JoinTable(
            name = "livro_genero",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "genero_id")
    )
    Set<Genero> generos;
    String editora;

}
