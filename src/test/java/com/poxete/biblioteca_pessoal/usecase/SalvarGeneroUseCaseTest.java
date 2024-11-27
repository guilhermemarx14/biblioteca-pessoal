package com.poxete.biblioteca_pessoal.usecase;

import com.poxete.biblioteca_pessoal.ConfiguraBaseEmMemoria;
import com.poxete.biblioteca_pessoal.model.Genero;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.google.common.truth.Truth.assertThat;

@SpringBootTest(properties = "spring.profiles.active=test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SalvarGeneroUseCaseTest {
    @Autowired
    ConfiguraBaseEmMemoria configuraBaseEmMemoria;

    @Autowired
    SalvarGeneroUseCase salvarGeneroUseCase;

    @BeforeAll
    public void setup() {
        configuraBaseEmMemoria.configurarBancoDeDados();
    }

    @Test
    void deveSalvarGenero() {
        var todosGenerosAntes = salvarGeneroUseCase.obterTodosOsGeneros();
        salvarGeneroUseCase.salvarGenero(new Genero("Não-ficção"));
        var todosGenerosDepois = salvarGeneroUseCase.obterTodosOsGeneros();
        assertThat(todosGenerosDepois.size()).isEqualTo(todosGenerosAntes.size() + 1);
    }
}
