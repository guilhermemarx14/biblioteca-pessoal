package com.poxete.biblioteca_pessoal.model;

import com.poxete.biblioteca_pessoal.utils.IgnorarNoCoverage;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

/**
 * Representa um autor de uma obra literária.
 */
@Data
@Entity
@ToString
@IgnorarNoCoverage
@NoArgsConstructor
@AllArgsConstructor
public class Autor {


    public Autor(String nome, Boolean favorito) {
        this.nome = nome;
        this.favorito = favorito != null && favorito;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String nome;


    String biografia;

    @NotNull
    Boolean favorito;


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Autor autor = (Autor) o;
        return id.equals(autor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
