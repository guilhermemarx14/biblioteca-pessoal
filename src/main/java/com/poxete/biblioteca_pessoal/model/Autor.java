package com.poxete.biblioteca_pessoal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Autor {
    public Autor(String nome, List<String> outrosNomes) {
        this.nome = nome;
        this.outrosNomes = outrosNomes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull
    String nome;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "autor_outros_nomes", joinColumns = @JoinColumn(name = "autor_id"))
    @Column(name = "outros_nomes")
    private List<String> outrosNomes;
}