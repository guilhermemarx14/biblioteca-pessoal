package com.poxete.biblioteca_pessoal.usecase;

import com.poxete.biblioteca_pessoal.ConfiguraBaseEmMemoria;
import com.poxete.biblioteca_pessoal.model.Livro;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

@SpringBootTest(properties = "spring.profiles.active=test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BuscarLivroUseCaseTest {
    @Autowired
    ConfiguraBaseEmMemoria configuraBaseEmMemoria;

    @Autowired
    BuscarLivrosUseCase buscarLivrosUseCase;

    @BeforeAll
    public void setup() {
        configuraBaseEmMemoria.configurarBancoDeDados();
    }

    @Test
    void deveBuscarLivroPorTitulo() {
        var query = "    d  c  ";

        var livros = buscarLivrosUseCase.buscarLivroPorTitulo(query);

        assertThat(livros.size()).isEqualTo(1);
        assertThat(livros.get(0).getId()).isEqualTo(2);
    }

    @Test
    void deveBuscarLivroPorTituloNaoEncontrado() {
        var query = "al;jfda;slddjasl";

        var livros = buscarLivrosUseCase.buscarLivroPorTitulo(query);

        assertThat(livros.isEmpty()).isTrue();
    }

    @Test
    void deveObterTodosOsLivros() {
        var livros = buscarLivrosUseCase.obterTodosOsLivros();

        assertThat(livros.size()).isEqualTo(6);
    }

    @Test
    void deveObterLivroBuscaGenerica() {
        var query = "    d  c  ";

        var livros = buscarLivrosUseCase.obterLivroBuscaGenerica(query);

        assertThat(livros.size()).isEqualTo(1);
        assertThat(livros.get(0).getId()).isEqualTo(2);

        query = "a";

        livros = buscarLivrosUseCase.obterLivroBuscaGenerica(query);
        var ids = List.of(0, 1, 2, 3, 4, 5);

        assertThat(livros.size()).isEqualTo(6);
        assertThat(livros.stream().map(Livro::getId).toList()).containsExactlyElementsIn(ids);

        var queryGenero = "Fantasia";

        livros = buscarLivrosUseCase.obterLivroBuscaGenerica(queryGenero);

        assertThat(livros.size()).isEqualTo(1);
        assertThat(livros.get(0).getId()).isEqualTo(0);
    }

}
