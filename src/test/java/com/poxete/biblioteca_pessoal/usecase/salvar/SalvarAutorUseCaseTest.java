package com.poxete.biblioteca_pessoal.usecase.salvar;

import com.poxete.biblioteca_pessoal.ConfiguraBaseEmMemoria;
import com.poxete.biblioteca_pessoal.model.Autor;
import com.poxete.biblioteca_pessoal.service.AutorService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

@SpringBootTest(properties = "spring.profiles.active=test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SalvarAutorUseCaseTest {
    @Autowired
    ConfiguraBaseEmMemoria configuraBaseEmMemoria;

    @Autowired
    SalvarAutorUseCase salvarAutorUseCase;

    @Autowired
    AutorService autorService;

    @BeforeAll
    public void setup() {
        configuraBaseEmMemoria.configurarBancoDeDados();
    }

    @Test
    void deveSalvarListaDeAutoresComAutoresIguais() {
        var quantidadeDeAutoresCadastrados = autorService.buscarTodos().size();
        salvarAutorUseCase.salvarLista(listaAutores());
        assertThat(autorService.buscarTodos().size()).isEqualTo(quantidadeDeAutoresCadastrados + 1);
    }

    @Test
    void deveSalvarListaDeAutoresComAutoresDiferentes() {
        var quantidadeDeAutoresCadastrados = autorService.buscarTodos().size();
        salvarAutorUseCase.salvarLista(listaAutoresDiferentes());
        assertThat(autorService.buscarTodos().size()).isEqualTo(quantidadeDeAutoresCadastrados + 2);
    }


    private List<Autor> listaAutores() {
        return List.of(new Autor("POXETE", true), new Autor("poxete", true));
    }

    private List<Autor> listaAutoresDiferentes() {
        return List.of(new Autor("POXETE", true), new Autor(" marx", true));
    }
}
