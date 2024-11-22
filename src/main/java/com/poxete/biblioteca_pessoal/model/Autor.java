package com.poxete.biblioteca_pessoal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

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
    List<String> outrosNomes;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Autor autor = (Autor) o;
        return Objects.equals(id, autor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
