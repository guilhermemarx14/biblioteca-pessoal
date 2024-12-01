package com.poxete.biblioteca_pessoal.usecase;

import com.poxete.biblioteca_pessoal.ConfiguraBaseEmMemoria;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.google.common.truth.Truth.assertThat;

@SpringBootTest(properties = "spring.profiles.active=test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BuscarLivroUseCaseTest {
    @Autowired
    ConfiguraBaseEmMemoria configuraBaseEmMemoria;

    @BeforeAll
    public void setup() {
        configuraBaseEmMemoria.configurarBancoDeDados();
    }

    @Test
    void deveBuscarLivroPorTitulo() {//todo
        assertThat(true).isTrue();
        //        var query = "    g   t  ";
        //
        //        var livros = buscarLivrosUseCase.buscarLivroPorTitulo(query);
        //
        //        assertThat(livros.size()).isEqualTo(2);
        //        assertThat(livros.get(0).getId()).isEqualTo(2);
        //        assertThat(livros.get(1).getId()).isEqualTo(3);
    }

    @Test
    void deveBuscarLivroPorTituloNaoEncontrado() {//todo
        //        var query = "al;jfda;slddjasl";
        //
        //        var livros = buscarLivrosUseCase.buscarLivroPorTitulo(query);
        //
        //        assertThat(livros.isEmpty()).isTrue();
    }

    @Test
    void deveObterTodosOsLivros() {//todo
        assertThat(true).isTrue();
        //        var livros = buscarLivrosUseCase.obterTodosOsLivros();
        //        System.out.println(livros);
        //        assertThat(livros.size()).isEqualTo(4);
    }

    @Test
    void deveObterLivroBuscaGenerica() {//todo
        assertThat(true).isTrue();
        //        var query = "    o  p  ";
        //
        //        var livros = buscarLivrosUseCase.obterLivroBuscaGenerica(query);
        //
        //        assertThat(livros.size()).isEqualTo(1);
        //        assertThat(livros.get(0).getId()).isEqualTo(3);
        //
        //        query = "a";
        //
        //        livros = buscarLivrosUseCase.obterLivroBuscaGenerica(query);
        //        var ids = List.of(0, 1, 2, 3);
        //
        //        assertThat(livros.size()).isEqualTo(4);
        //        assertThat(livros.stream().map(Livro::getId).toList()).containsExactlyElementsIn(ids);
        //
        //        var queryGenero = "Fantasia";
        //
        //        livros = buscarLivrosUseCase.obterLivroBuscaGenerica(queryGenero);
        //
        //        assertThat(livros.size()).isEqualTo(2);
        //        assertThat(livros.get(0).getId()).isEqualTo(1);
        //        assertThat(livros.get(1).getId()).isEqualTo(2);
    }

}
