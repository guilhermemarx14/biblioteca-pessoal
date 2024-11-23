package com.poxete.biblioteca_pessoal;

import com.google.common.truth.Truth;
import com.poxete.biblioteca_pessoal.utils.Utils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
class UtilsTest {
    @Test
    void testPrepararLikeParaBuscaGenerica_ComQueryVazia_RetornaQueryVazia() {
        String query = "";
        String like = Utils.prepararLikeParaBuscaGenerica(query);
        Truth.assertThat(like).isEmpty();
    }

    @Test
    void testPrepararLikeParaBuscaGenerica_ComQueryNull_RetornaQueryVazia() {
        String query = null;
        String like = Utils.prepararLikeParaBuscaGenerica(query);
        Truth.assertThat(like).isEmpty();
    }

    @Test
    void testPrepararLikeParaBuscaGenerica_ComQueryComEspacos_RetornaQueryComEspacosRemovidos() {
        String query = "   ";
        String like = Utils.prepararLikeParaBuscaGenerica(query);
        Truth.assertThat(like).isEqualTo("");
    }

    @Test
    void testPrepararLikeParaBuscaGenerica_ComQueryComCaracteresEspeciais_RetornaQueryComCaracteresEspeciaisRemovidos() {
        String query = "abc%def";
        String like = Utils.prepararLikeParaBuscaGenerica(query);
        Truth.assertThat(like).isEqualTo("%ABC%DEF%");
    }

    @Test
    void testFormatarListaComE_ComListaVazia_RetornaStringVazia() {
        List<String> lista = List.of();
        String resultado = Utils.formatarListaComE(lista);
        Truth.assertThat(resultado).isEmpty();
    }

    @Test
    void testFormatarListaComE_ComListaComUmElemento_RetornaElemento() {
        List<String> lista = List.of("abc");
        String resultado = Utils.formatarListaComE(lista);
        Truth.assertThat(resultado).isEqualTo("abc");
    }

    @Test
    void testFormatarListaComE_ComListaComMultiplosElementos_RetornaListaFormatada() {
        List<String> lista = List.of("abc", "def", "ghi");
        String resultado = Utils.formatarListaComE(lista);
        Truth.assertThat(resultado).isEqualTo("abc, def e ghi");
    }
}
