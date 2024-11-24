package com.poxete.biblioteca_pessoal.usecase;

import com.poxete.biblioteca_pessoal.ConfiguraBaseEmMemoria;
import com.poxete.biblioteca_pessoal.model.Autor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.google.common.truth.Truth.assertThat;

@SpringBootTest(properties = "spring.profiles.active=test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BuscarDadosAutorUseCaseTest {
    @Autowired
    ConfiguraBaseEmMemoria configuraBaseEmMemoria;

    @Autowired
    BuscarDadosAutorUseCase buscarDadosAutorUseCase;

    @BeforeAll
    public void setup() {
        configuraBaseEmMemoria.configurarBancoDeDados();
    }

    @Test
    void deveBuscarDadosDoAutor() {
        var autor = new Autor("William Shakespeare");

        assertThat(buscarDadosAutorUseCase.buscarDadosAutor(autor).getBiografia()).isNotNull();
    }

    @Test
    void deveBuscarDadosDoAutor_falha() {
        var autor = new Autor("fififififiififfififiif");

        assertThat(buscarDadosAutorUseCase.buscarDadosAutor(autor).getBiografia()).isNull();
    }
}
