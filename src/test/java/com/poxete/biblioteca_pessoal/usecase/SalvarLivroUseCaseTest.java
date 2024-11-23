package com.poxete.biblioteca_pessoal.usecase;

import com.poxete.biblioteca_pessoal.ConfiguraBaseEmMemoria;
import com.poxete.biblioteca_pessoal.model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

@SpringBootTest(properties = "spring.profiles.active=test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SalvarLivroUseCaseTest {
    @Autowired
    ConfiguraBaseEmMemoria configuraBaseEmMemoria;

    @Autowired
    SalvarLivroUseCase salvarLivroUseCase;

    @Test
    void deveSalvarLivro() {
        var livroSalvo = salvarLivroUseCase.salvarLivro(mockLivro());
        assertThat(livroSalvo).isNotNull();
        assertThat(livroSalvo.toString()).isEqualTo("\n{\n\tTitulo: titulo\n\tAutores: Autor(id=6, nome=nomeAutor, outrosNomes=null)\n\tNota: ***\n}");
    }

    private Livro mockLivro() {
        var nomeEditora = "nomeEditora";
        var nomeAutor = "nomeAutor";
        var genero = "genero";
        var localizacaoS = "localizacao";
        var titulo = "titulo";
        var anoPublicacao = 0;
        var generos = new Genero(genero);
        var autores = new Autor(nomeAutor, null);
        var editora = new Editora(nomeEditora);
        var localizacao = new Localizacao(localizacaoS);
        var quantidade = 0;
        var livro = new Livro(titulo, anoPublicacao, List.of(generos), List.of(autores), editora, localizacao, quantidade);
        livro.setClassificacao(3);
        livro.setDataLeitura(new Date(LocalDate.now().toEpochDay()));
        livro.setComentario("comentario");
        return livro;
    }

    @BeforeAll
    public void setup() {
        configuraBaseEmMemoria.configurarBancoDeDados();
    }
}
