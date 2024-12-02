package com.poxete.biblioteca_pessoal.model;


import com.poxete.biblioteca_pessoal.utils.IgnorarNoCoverage;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@Data
@Entity
@ToString
@IgnorarNoCoverage
@NoArgsConstructor
@AllArgsConstructor
public class Localizacao {
    public Localizacao(String descricao) {
        this.descricao = descricao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    String descricao;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Localizacao that = (Localizacao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
