package com.poxete.biblioteca_pessoal.usecase;

import com.poxete.biblioteca_pessoal.ConfiguraBaseEmMemoria;
import com.poxete.biblioteca_pessoal.exception.AutorNaoEncontradoException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.google.common.truth.Truth.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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
        assertThat(buscarDadosAutorUseCase.buscarDadosAutor("Isaac Asimov").getBiografia()).isNotNull();
    }

    @Test
    void deveBuscarDadosDoAutor_falhaBiografia() {
        assertThat(buscarDadosAutorUseCase.buscarDadosAutor("Poxete").getBiografia()).isEqualTo("Não foi possivel obter a biografia de Poxete");
    }

    @Test
    void deveBuscarDadosDoAutor_falhaAutor() {
        assertThatExceptionOfType(AutorNaoEncontradoException.class).isThrownBy(() -> buscarDadosAutorUseCase.buscarDadosAutor("asdfadf"))
                .withMessage("Autor Asdfadf não encontrado");
    }
}
