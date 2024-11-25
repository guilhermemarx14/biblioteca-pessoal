package com.poxete.biblioteca_pessoal.usecase;

import com.poxete.biblioteca_pessoal.ConfiguraBaseEmMemoria;
import com.poxete.biblioteca_pessoal.controller.dto.LivroCompletoDTO;
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
        assertThat(livroSalvo.toString()).isEqualTo("{ Id: 4 || Titulo: Titulo que Não É Real || Autores: Nomeautor de Sobrenomeautor || Nota: *** }");
    }

    private LivroCompletoDTO mockLivro() {


        return new LivroCompletoDTO(
                "titulo que não é real",
                Boolean.FALSE,
                0,
                List.of("genero"),
                List.of("nomeAutor de sobrenomeAutor"),
                "nomeEditora",
                "localizacao",
                3,
                3,
                new Date(LocalDate.now().toEpochDay()),
                "comentario"
        );

    }

    @BeforeAll
    public void setup() {
        configuraBaseEmMemoria.configurarBancoDeDados();
    }
}
