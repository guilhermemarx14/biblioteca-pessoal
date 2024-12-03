package com.poxete.biblioteca_pessoal.usecase.obter;


import com.poxete.biblioteca_pessoal.ConfiguraBaseEmMemoria;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.google.common.truth.Truth.assertThat;

@SpringBootTest(properties = "spring.profiles.active=test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ObterDetalhesAutorUseCaseTest {
    @Autowired
    ConfiguraBaseEmMemoria configuraBaseEmMemoria;

    @Autowired
    ObterDetalhesAutorUseCase obterDetalhesAutorUseCase;

    @BeforeAll
    public void setup() {
        configuraBaseEmMemoria.configurarBancoDeDados();
    }

    @Test
    void deveObterTodosOsAutores() {
        assertThat(obterDetalhesAutorUseCase.obterTodosOsAutores().size()).isEqualTo(6);
    }

    @Test
    void deveObterUmAutor() {
        assertThat(obterDetalhesAutorUseCase.obterDetalhesAutor("Christian Dunker").getId()).isEqualTo(1);
    }
}
