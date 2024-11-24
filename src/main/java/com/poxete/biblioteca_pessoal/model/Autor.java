package com.poxete.biblioteca_pessoal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Autor {

    @Id
    String nome;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "autor_outros_nomes", joinColumns = @JoinColumn(name = "autor_id"))
    @Column(name = "outros_nomes")
    List<String> outrosNomes;


    @Override
    public boolean equals(Object o) {
        var todosNomes = new ArrayList<>(outrosNomes);
        todosNomes.add(nome);

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Autor autor = (Autor) o;
        return todosNomes.contains(autor.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
