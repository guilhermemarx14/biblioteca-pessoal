package com.poxete.biblioteca_pessoal.model;

import com.google.common.truth.Truth;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class LocalizacaoTest {
    @Test
    void testEquals_SameObject_ReturnsTrue() {
        Localizacao localizacao = new Localizacao("Biblioteca");
        Truth.assertThat(localizacao.equals(localizacao)).isTrue();
    }

    @Test
    void testEquals_DifferentObjectWithSameId_ReturnsTrue() {
        Localizacao localizacao1 = new Localizacao("Biblioteca");
        Localizacao localizacao2 = new Localizacao("Biblioteca");
        Truth.assertThat(localizacao1.equals(localizacao2)).isTrue();
    }

    @Test
    void testEquals_DifferentObjectWithDifferentId_ReturnsFalse() {
        Localizacao localizacao1 = new Localizacao("Biblioteca");
        Localizacao localizacao2 = new Localizacao("Arquivo");
        Truth.assertThat(localizacao1.equals(localizacao2)).isFalse();
    }

    @Test
    void testEquals_DifferentObjectType_ReturnsFalse() {
        Localizacao localizacao = new Localizacao("Biblioteca");
        Truth.assertThat(localizacao.equals("Biblioteca")).isFalse();
    }

    @Test
    void testEquals_NullObject_ReturnsFalse() {
        Localizacao localizacao = new Localizacao("Biblioteca");
        Truth.assertThat(localizacao.equals(null)).isFalse();
    }

    @Test
    void testHashCode_SameObject_ReturnsSameHashCode() {
        Localizacao localizacao1 = new Localizacao("Biblioteca");
        Localizacao localizacao2 = new Localizacao("Biblioteca");
        Truth.assertThat(localizacao1.hashCode()).isEqualTo(localizacao2.hashCode());
    }

    @Test
    void testHashCode_DifferentObjectWithDifferentId_ReturnsDifferentHashCode() {
        Localizacao localizacao1 = new Localizacao("Biblioteca");
        Localizacao localizacao2 = new Localizacao("Arquivo");
        Truth.assertThat(localizacao1.hashCode()).isNotEqualTo(localizacao2.hashCode());
    }
}
