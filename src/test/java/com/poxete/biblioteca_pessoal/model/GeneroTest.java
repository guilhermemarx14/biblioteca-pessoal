package com.poxete.biblioteca_pessoal.model;

import com.google.common.truth.Truth;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class GeneroTest {
    @Test
    void testEquals_SameObject_ReturnsTrue() {
        Genero genero = new Genero("Romance");
        Truth.assertThat(genero.equals(genero)).isTrue();
    }

    @Test
    void testEquals_DifferentObjectWithSameId_ReturnsTrue() {
        Genero genero1 = new Genero("Romance");
        Genero genero2 = new Genero("Romance");
        Truth.assertThat(genero1.equals(genero2)).isTrue();
    }

    @Test
    void testEquals_DifferentObjectWithDifferentId_ReturnsFalse() {
        Genero genero1 = new Genero("Romance");
        Genero genero2 = new Genero("Ficção");
        Truth.assertThat(genero1.equals(genero2)).isFalse();
    }

    @Test
    void testEquals_DifferentObjectType_ReturnsFalse() {
        Genero genero = new Genero("Romance");
        Truth.assertThat(genero.equals("Romance")).isFalse();
    }

    @Test
    void testEquals_NullObject_ReturnsFalse() {
        Genero genero = new Genero("Romance");
        Truth.assertThat(genero.equals(null)).isFalse();
    }

    @Test
    void testHashCode_SameObject_ReturnsSameHashCode() {
        Genero genero1 = new Genero("Romance");
        Genero genero2 = new Genero("Romance");
        Truth.assertThat(genero1.hashCode()).isEqualTo(genero2.hashCode());
    }

    @Test
    void testHashCode_DifferentObjectWithDifferentId_ReturnsDifferentHashCode() {
        Genero genero1 = new Genero("Romance");
        Genero genero2 = new Genero("Ficção");
        Truth.assertThat(genero1.hashCode()).isNotEqualTo(genero2.hashCode());
    }
}
