package com.poxete.biblioteca_pessoal.usecase.salvar;

import com.poxete.biblioteca_pessoal.ConfiguraBaseEmMemoria;
import com.poxete.biblioteca_pessoal.model.Autor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

@SpringBootTest(properties = "spring.profiles.active=test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SalvarAutorUseCaseTest {
    @Autowired
    ConfiguraBaseEmMemoria configuraBaseEmMemoria;

    @Autowired
    SalvarAutorUseCase salvarAutorUseCase;

    @BeforeAll
    public void setup() {
        configuraBaseEmMemoria.configurarBancoDeDados();
    }

    @Test
    void deveSalvarListaDeAutoresComAutoresIguais() {
        var autores = new ArrayList<>(salvarAutorUseCase.salvarLista(listaAutores()));
        assertThat(autores.getFirst()).isEqualTo(autores.getLast());
    }

    @Test
    void deveSalvarListaDeAutoresComAutoresDiferentes() {
        var lista = new ArrayList<>(salvarAutorUseCase.salvarLista(listaAutoresDiferentes()));
        assertThat(lista.getFirst().getId()).isNotNull();
    }


    private List<Autor> listaAutores() {
        return List.of(new Autor("POXETE", true), new Autor("poxete", true));
    }

    private List<Autor> listaAutoresDiferentes() {
        return List.of(new Autor("POXETE", true), new Autor(" marx", true));
    }
}
