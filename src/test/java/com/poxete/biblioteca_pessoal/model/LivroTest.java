package com.poxete.biblioteca_pessoal.model;

import com.google.common.truth.Truth;
import org.junit.jupiter.api.Test;

import java.util.List;

class LivroTest {
    @Test
    void testEquals_SameObject_ReturnsTrue() {
        Livro livro = new Livro(
                "Título",
                2020,
                List.of(new Genero("Gênero")),
                List.of(new Autor("Autor", null, false)),
                new Editora("Editora"),
                new Localizacao("Localização"),
                10
        );
        Truth.assertThat(livro.equals(livro)).isTrue();
    }

    @Test
    void testEquals_DifferentObjectWithSameId_ReturnsTrue() {
        Livro livro1 = new Livro(
                "Título",
                2020,
                List.of(new Genero("Gênero")),
                List.of(new Autor("Autor", null, false)),
                new Editora("Editora"),
                new Localizacao("Localização"),
                10
        );
        Livro livro2 = new Livro(
                "Título",
                2020,
                List.of(new Genero("Gênero")),
                List.of(new Autor("Autor", null, false)),
                new Editora("Editora"),
                new Localizacao("Localização"),
                10
        );
        livro1.id = 1;
        livro2.id = 1;
        Truth.assertThat(livro1.equals(livro2)).isTrue();
    }

    @Test
    void testEquals_DifferentObjectWithDifferentId_ReturnsFalse() {
        Livro livro1 = new Livro(
                "Título",
                2020,
                List.of(new Genero("Gênero")),
                List.of(new Autor("Autor", null, false)),
                new Editora("Editora"),
                new Localizacao("Localização"),
                10
        );
        Livro livro2 = new Livro(
                "Título",
                2020,
                List.of(new Genero("Gênero")),
                List.of(new Autor("Autor", null, false)),
                new Editora("Editora"),
                new Localizacao("Localização"),
                10
        );
        livro1.id = 1;
        livro2.id = 2;
        Truth.assertThat(livro1.equals(livro2)).isFalse();
    }

    @Test
    void testEquals_DifferentObjectType_ReturnsFalse() {
        Livro livro = new Livro(
                "Título",
                2020,
                List.of(new Genero("Gênero")),
                List.of(new Autor("Autor", null, false)),
                new Editora("Editora"),
                new Localizacao("Localização"),
                10
        );
        Truth.assertThat(livro.equals("Título")).isFalse();
    }

    @Test
    void testEquals_NullObject_ReturnsFalse() {
        Livro livro = new Livro(
                "Título",
                2020,
                List.of(new Genero("Gênero")),
                List.of(new Autor("Autor", null, false)),
                new Editora("Editora"),
                new Localizacao("Localização"),
                10
        );
        Truth.assertThat(livro.equals(null)).isFalse();
    }

    @Test
    void testHashCode_SameObject_ReturnsSameHashCode() {
        Livro livro = new Livro(
                "Título",
                2020,
                List.of(new Genero("Gênero")),
                List.of(new Autor("Autor", null, false)),
                new Editora("Editora"),
                new Localizacao("Localização"),
                10
        );
        Truth.assertThat(livro.hashCode()).isEqualTo(livro.hashCode());
    }

    @Test
    void testHashCode_DifferentObjectWithSameId_ReturnsSameHashCode() {
        Livro livro1 = new Livro(
                "Título",
                2020,
                List.of(new Genero("Gênero")),
                List.of(new Autor("Autor", null, false)),
                new Editora("Editora"),
                new Localizacao("Localização"),
                10
        );
        Livro livro2 = new Livro(
                "Título",
                2020,
                List.of(new Genero("Gênero")),
                List.of(new Autor("Autor", null, false)),
                new Editora("Editora"),
                new Localizacao("Localização"),
                10
        );
        livro1.id = 1;
        livro2.id = 1;
        Truth.assertThat(livro1.hashCode()).isEqualTo(livro2.hashCode());
    }

    @Test
    void testHashCode_DifferentObjectWithDifferentId_ReturnsDifferentHashCode() {
        Livro livro1 = new Livro(
                "Título",
                2020,
                List.of(new Genero("Gênero")),
                List.of(new Autor("Autor", null, false)),
                new Editora("Editora"),
                new Localizacao("Localização"),
                10
        );
        Livro livro2 = new Livro(
                "Título",
                2020,
                List.of(new Genero("Gênero")),
                List.of(new Autor("Autor", null, false)),
                new Editora("Editora"),
                new Localizacao("Localização"),
                10
        );
        livro1.id = 1;
        livro2.id = 2;
        Truth.assertThat(livro1.hashCode()).isNotEqualTo(livro2.hashCode());
    }
}
