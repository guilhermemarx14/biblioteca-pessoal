package com.poxete.biblioteca_pessoal.model;

import com.google.common.truth.Truth;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class EditoraTest {
    @Test
    void testEquals_SameObject_ReturnsTrue() {
        Editora editora = new Editora("Editora Brasil");
        Truth.assertThat(editora.equals(editora)).isTrue();
    }

    @Test
    void testEquals_DifferentObjectWithSameId_ReturnsTrue() {
        Editora editora1 = new Editora("Editora Brasil");
        Editora editora2 = new Editora("Editora Brasil");
        Truth.assertThat(editora1.equals(editora2)).isTrue();
    }

    @Test
    void testEquals_DifferentObjectWithDifferentId_ReturnsFalse() {
        Editora editora1 = new Editora("Editora Brasil");
        Editora editora2 = new Editora("Editora Portugal");
        Truth.assertThat(editora1.equals(editora2)).isFalse();
    }

    @Test
    void testEquals_DifferentObjectType_ReturnsFalse() {
        Editora editora = new Editora("Editora Brasil");
        Truth.assertThat(editora.equals("Editora Brasil")).isFalse();
    }

    @Test
    void testEquals_NullObject_ReturnsFalse() {
        Editora editora = new Editora("Editora Brasil");
        Truth.assertThat(editora.equals(null)).isFalse();
    }

    @Test
    void testHashCode_SameObject_ReturnsSameHashCode() {
        Editora editora1 = new Editora("Editora Brasil");
        Editora editora2 = new Editora("Editora Brasil");
        Truth.assertThat(editora1.hashCode()).isEqualTo(editora2.hashCode());
    }

    @Test
    void testHashCode_DifferentObjectWithSameId_ReturnsSameHashCode() {
        Editora editora1 = new Editora("Editora Brasil");
        Editora editora2 = new Editora("Editora Brasil");
        Truth.assertThat(editora1.hashCode()).isEqualTo(editora2.hashCode());
    }

    @Test
    void testHashCode_DifferentObjectWithDifferentId_ReturnsDifferentHashCode() {
        Editora editora1 = new Editora("Editora Brasil");
        Editora editora2 = new Editora("Editora Portugal");
        Truth.assertThat(editora1.hashCode()).isNotEqualTo(editora2.hashCode());
    }
}
