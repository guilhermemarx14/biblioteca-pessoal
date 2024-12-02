package com.poxete.biblioteca_pessoal;

import com.poxete.biblioteca_pessoal.utils.Utils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

@ExtendWith(SpringExtension.class)
class UtilsTest {
    @Test
    void testPrepararLikeParaBuscaGenerica_ComQueryVazia_RetornaQueryVazia() {
        String query = "";
        String like = Utils.prepararLikeParaBuscaGenerica(query);
        assertThat(like).isEmpty();
    }

    @Test
    void testPrepararLikeParaBuscaGenerica_ComQueryNull_RetornaQueryVazia() {
        String query = null;
        String like = Utils.prepararLikeParaBuscaGenerica(query);
        assertThat(like).isEmpty();
    }

    @Test
    void testPrepararLikeParaBuscaGenerica_ComQueryComEspacos_RetornaQueryComEspacosRemovidos() {
        String query = "   ";
        String like = Utils.prepararLikeParaBuscaGenerica(query);
        assertThat(like).isEqualTo("");
    }

    @Test
    void testPrepararLikeParaBuscaGenerica_ComQueryComCaracteresEspeciais_RetornaQueryComCaracteresEspeciaisRemovidos() {
        String query = "abc%def";
        String like = Utils.prepararLikeParaBuscaGenerica(query);
        assertThat(like).isEqualTo("%ABC%DEF%");
    }

    @Test
    void testFormatarListaComE_ComListaVazia_RetornaStringVazia() {
        List<String> lista = List.of();
        String resultado = Utils.formatarListaComE(lista);
        assertThat(resultado).isEmpty();
    }

    @Test
    void testFormatarListaComE_ComListaComUmElemento_RetornaElemento() {
        List<String> lista = List.of("abc");
        String resultado = Utils.formatarListaComE(lista);
        assertThat(resultado).isEqualTo("abc");
    }

    @Test
    void testFormatarListaComE_ComListaComMultiplosElementos_RetornaListaFormatada() {
        List<String> lista = List.of("abc", "def", "ghi");
        String resultado = Utils.formatarListaComE(lista);
        assertThat(resultado).isEqualTo("abc, def e ghi");
    }

    @Test
    void testCapitalizarPalavras() {
        String texto = "o livro de java é muito interessante";
        String resultado = Utils.capitalizarPalavras(texto);
        assertThat(resultado).isEqualTo("O Livro de Java É Muito Interessante");

        texto = "suco de uva";
        resultado = Utils.capitalizarPalavras(texto);
        assertThat(resultado).isEqualTo("Suco de Uva");

        texto = "suco da uva";
        resultado = Utils.capitalizarPalavras(texto);
        assertThat(resultado).isEqualTo("Suco da Uva");

        texto = "suco das uva";
        resultado = Utils.capitalizarPalavras(texto);
        assertThat(resultado).isEqualTo("Suco das Uva");

        texto = "dia do julgamento";
        resultado = Utils.capitalizarPalavras(texto);
        assertThat(resultado).isEqualTo("Dia do Julgamento");

        texto = "Dia dos santos";
        resultado = Utils.capitalizarPalavras(texto);
        assertThat(resultado).isEqualTo("Dia dos Santos");

        texto = "  multiplos  espacos  ";
        resultado = Utils.capitalizarPalavras(texto);
        assertThat(resultado).isEqualTo("Multiplos Espacos");

        texto = "j. r. r. Tolkien";
        resultado = Utils.capitalizarPalavras(texto);
        assertThat(resultado).isEqualTo("J. R. R. Tolkien");

        texto = "guarda-chuva";
        resultado = Utils.capitalizarPalavras(texto);
        assertThat(resultado).isEqualTo("Guarda-chuva");

        texto = null;
        resultado = Utils.capitalizarPalavras(texto);
        assertThat(resultado).isEqualTo("");

        texto = "    ";
        resultado = Utils.capitalizarPalavras(texto);
        assertThat(resultado).isEqualTo("");

        texto = "flores e odores";
        resultado = Utils.capitalizarPalavras(texto);
        assertThat(resultado).isEqualTo("Flores e Odores");

    }

    @Test
    void deveObterListaDeStringsViaSplit() {
        var texto = "autor1;autor2";
        var resultado = Utils.obterItensDeListaAPartirDeString(texto);
        assertThat(resultado).containsExactlyElementsIn(List.of("autor1", "autor2"));

        texto = null;
        resultado = Utils.obterItensDeListaAPartirDeString(texto);
        assertThat(resultado.isEmpty()).isTrue();

        texto = "";
        resultado = Utils.obterItensDeListaAPartirDeString(texto);
        assertThat(resultado.isEmpty()).isTrue();

        texto = "autor1";
        resultado = Utils.obterItensDeListaAPartirDeString(texto);
        assertThat(resultado).containsExactlyElementsIn(List.of("autor1"));


    }

    @Test
    void deveObterStringAPartirDeLista() {
        List<String> strings = List.of("String1");
        var resultado = Utils.obterStringAPartirDeLista(strings);
        assertThat(resultado).isEqualTo("String1");

        strings = List.of("String1", "String2");
        resultado = Utils.obterStringAPartirDeLista(strings);
        assertThat(resultado).isEqualTo("String1;String2");
    }

}
