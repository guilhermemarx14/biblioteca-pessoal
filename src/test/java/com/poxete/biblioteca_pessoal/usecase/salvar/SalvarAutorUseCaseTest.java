package com.poxete.biblioteca_pessoal.usecase.salvar;

import com.poxete.biblioteca_pessoal.ConfiguraBaseEmMemoria;
import com.poxete.biblioteca_pessoal.model.Autor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    //    @Test
    //    void deveSalvarListaDeAutoresComAutoresIguais() {
    //        var autores = new ArrayList<>(salvarAutorUseCase.salvarLista(listaAutores()));
    //        assertThat(autores.get(0)).isEqualTo(autores.get(autores.size() - 1));
    //    }

    //    @Test
    //    void deveSalvarListaDeAutoresComAutoresDiferentes() {
    //        var lista = new ArrayList<>(salvarAutorUseCase.salvarLista(listaAutoresDiferentes()));
    //        assertThat(lista.get(0).getId()).isNotNull();
    //    }


    private List<Autor> listaAutores() {
        return List.of(new Autor("POXETE", true), new Autor("poxete", true));
    }

    private List<Autor> listaAutoresDiferentes() {
        return List.of(new Autor("POXETE", true), new Autor(" marx", true));
    }
}
