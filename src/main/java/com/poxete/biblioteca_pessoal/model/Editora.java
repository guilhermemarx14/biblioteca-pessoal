package com.poxete.biblioteca_pessoal.model;

import com.poxete.biblioteca_pessoal.utils.IgnorarNoCoverage;
import com.poxete.biblioteca_pessoal.utils.Utils;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Entity
@IgnorarNoCoverage
@NoArgsConstructor
@AllArgsConstructor
public class Editora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String nome;

    public Editora(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Editora editora = (Editora) o;
        return Objects.equals(id, editora.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return Utils.capitalizarPalavras(nome);
    }
}
