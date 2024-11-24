package com.poxete.biblioteca_pessoal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Editora {
    @Id
    String nome;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Editora editora = (Editora) o;
        return Objects.equals(nome, editora.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
