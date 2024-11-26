package com.poxete.biblioteca_pessoal.model;

import com.google.common.truth.Truth;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
class AutorTest {
    @Test
    void testEquals_SameObject_ReturnsTrue() {
        Autor autor = new Autor("John Doe", List.of("Jane Smith"), false);
        Truth.assertThat(autor.equals(autor)).isTrue();
    }

    @Test
    void testEquals_DifferentObjectWithSameId_ReturnsTrue() {
        Autor autor1 = new Autor("John Doe", List.of("Jane Smith"), false);
        Autor autor2 = new Autor("John Doe", List.of("Jane Smith"), false);
        Truth.assertThat(autor1.equals(autor2)).isTrue();
    }

    @Test
    void testEquals_DifferentObjectNomesTrocadosRetornaTrue() {
        Autor autor1 = new Autor("John Doe", List.of("Jane Smith"), false);
        Autor autor2 = new Autor("Jane Smith", List.of("John Doe"), false);
        Truth.assertThat(autor1.equals(autor2)).isTrue();
    }

    @Test
    void testEquals_DifferentObjectType_ReturnsFalse() {
        Autor autor = new Autor("John Doe", List.of("Jane Smith"), false);
        Truth.assertThat(autor.equals("John Doe")).isFalse();
    }

    @Test
    void testEquals_NullObject_ReturnsFalse() {
        Autor autor = new Autor("John Doe", List.of("Jane Smith"), false);
        Truth.assertThat(autor.equals(null)).isFalse();
    }

    @Test
    void testHashCode_SameObject_ReturnsSameHashCode() {
        Autor autor1 = new Autor("John Doe", List.of("Jane Smith"), false);
        Autor autor2 = new Autor("John Doe", List.of("Jane Smith"), false);
        Truth.assertThat(autor1.hashCode()).isEqualTo(autor2.hashCode());
    }

    @Test
    void testHashCode_DifferentObjectWithDifferentId_ReturnsDifferentHashCode() {
        Autor autor1 = new Autor("John Doe", List.of("Jane Smith"), false);
        Autor autor2 = new Autor("Jane Smith", List.of("John Doe"), false);
        Truth.assertThat(autor1.hashCode()).isNotEqualTo(autor2.hashCode());
    }
}
