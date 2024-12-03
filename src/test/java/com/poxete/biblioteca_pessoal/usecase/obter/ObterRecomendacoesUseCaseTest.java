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
class ObterRecomendacoesUseCaseTest {
    @Autowired
    ObterRecomendacoesUseCase obterRecomendacoesUseCase;

    @Autowired
    ConfiguraBaseEmMemoria configuraBaseEmMemoria;

    @BeforeAll
    void setup() {
        configuraBaseEmMemoria.configurarBancoDeDados();
    }

    @Test
    void obterRecomendacoes() {
        assertThat(obterRecomendacoesUseCase.obterRecomendacoes()).isNotEmpty();
    }

}
