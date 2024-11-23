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
        Autor autor = new Autor("John Doe", List.of("Jane Smith"));
        Truth.assertThat(autor.equals(autor)).isTrue();
    }

    @Test
    void testEquals_DifferentObjectWithSameId_ReturnsTrue() {
        Autor autor1 = new Autor("John Doe", List.of("Jane Smith"));
        Autor autor2 = new Autor("John Doe", List.of("Jane Smith"));
        Truth.assertThat(autor1.equals(autor2)).isTrue();
    }

    @Test
    void testEquals_DifferentObjectWithDifferentId_ReturnsFalse() {
        Autor autor1 = new Autor("John Doe", List.of("Jane Smith"));
        autor1.id = 1;
        Autor autor2 = new Autor("Jane Smith", List.of("John Doe"));
        autor2.id = 2;
        Truth.assertThat(autor1.equals(autor2)).isFalse();
    }

    @Test
    void testEquals_DifferentObjectType_ReturnsFalse() {
        Autor autor = new Autor("John Doe", List.of("Jane Smith"));
        Truth.assertThat(autor.equals("John Doe")).isFalse();
    }

    @Test
    void testEquals_NullObject_ReturnsFalse() {
        Autor autor = new Autor("John Doe", List.of("Jane Smith"));
        Truth.assertThat(autor.equals(null)).isFalse();
    }

    @Test
    void testHashCode_SameObject_ReturnsSameHashCode() {
        Autor autor1 = new Autor("John Doe", List.of("Jane Smith"));
        Autor autor2 = new Autor("John Doe", List.of("Jane Smith"));
        Truth.assertThat(autor1.hashCode()).isEqualTo(autor2.hashCode());
    }

    @Test
    void testHashCode_DifferentObjectWithSameId_ReturnsSameHashCode() {
        Autor autor1 = new Autor("John Doe", List.of("Jane Smith"));
        Autor autor2 = new Autor("John Doe", List.of("Jane Smith"));
        Truth.assertThat(autor1.hashCode()).isEqualTo(autor2.hashCode());
    }

    @Test
    void testHashCode_DifferentObjectWithDifferentId_ReturnsDifferentHashCode() {
        Autor autor1 = new Autor("John Doe", List.of("Jane Smith"));
        autor1.id = 1;
        Autor autor2 = new Autor("Jane Smith", List.of("John Doe"));
        autor2.id = 2;
        Truth.assertThat(autor1.hashCode()).isNotEqualTo(autor2.hashCode());
    }
}
