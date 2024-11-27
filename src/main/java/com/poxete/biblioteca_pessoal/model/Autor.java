package com.poxete.biblioteca_pessoal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representa um autor de uma obra literária.
 */
@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Autor {


    /**
     * Constrói um autor com o nome e lista de nomes alternativos fornecidos.
     *
     * @param nome              o nome do autor
     * @param nomesAlternativos lista de nomes alternativos do autor
     */
    public Autor(String nome, List<String> nomesAlternativos, Boolean favorito) {
        this.nome = nome;
        this.outrosNomes = nomesAlternativos;
        this.favorito = favorito;
    }

    /**
     * O nome do autor, que serve como identificador único.
     */
    @Id
    String nome;

    /**
     * Lista de nomes alternativos do autor.
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "autor_outros_nomes", joinColumns = @JoinColumn(name = "autor_id"))
    @Column(name = "outros_nomes")
    List<String> outrosNomes;

    /**
     * A biografia do autor, que não é persistida no banco de dados.
     * Ela é obtida do wikipedia no momento da execução.
     */
    @Transient
    String biografia;

    /**
     * Se o autor é favorito ou não.
     */
    Boolean favorito;

    /**
     * Verifica se o autor é igual a outro objeto. (somente os nomes serem iguais já é suficiente por ele ser chave primária)
     *
     * @param o o objeto a comparar
     * @return true se o autor for igual ao objeto, false caso contrário
     */
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

    /**
     * Retorna o hash code do autor, baseado no nome. (somente o nome já é suficiente por ele ser chave primária)
     *
     * @return o hash code do autor
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
