package com.poxete.biblioteca_pessoal.usecase;

import com.poxete.biblioteca_pessoal.ConfiguraBaseEmMemoria;
import com.poxete.biblioteca_pessoal.service.dto.LivroCompletoDTO;
import com.poxete.biblioteca_pessoal.usecase.salvar.SalvarLivroUseCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

@SpringBootTest(properties = "spring.profiles.active=test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SalvarLivroUseCaseTest {
    @Autowired
    ConfiguraBaseEmMemoria configuraBaseEmMemoria;

    @Autowired
    SalvarLivroUseCase salvarLivroUseCase;

    @BeforeAll
    public void setup() {
        configuraBaseEmMemoria.configurarBancoDeDados();
    }

    @Test
    void deveSalvarLivroNovo() {
        var livroSalvo = salvarLivroUseCase.salvarLivro(mockLivroCompletoDTO());

        assertThat(livroSalvo.getId()).isEqualTo(3);
    }

    private LivroCompletoDTO mockLivroCompletoDTO() {
        return LivroCompletoDTO.builder()
                .titulo("titulo")
                .lido(true)
                .anoPublicacao(2020)
                .generos(List.of("genero"))
                .autores(List.of("Poxete"))
                .editora("editora")
                .localizacao("localizacao")
                .quantidade(1)
                .classificacao(1)
                .dataLeitura(null)
                .comentario("comentario")
                .sinopse("sinopse")
                .favorito(true)
                .build();
    }
}
