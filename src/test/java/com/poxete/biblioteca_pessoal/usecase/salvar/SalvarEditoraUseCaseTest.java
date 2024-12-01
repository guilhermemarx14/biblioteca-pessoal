package com.poxete.biblioteca_pessoal.usecase.salvar;

import com.poxete.biblioteca_pessoal.ConfiguraBaseEmMemoria;
import com.poxete.biblioteca_pessoal.model.Editora;
import com.poxete.biblioteca_pessoal.service.EditoraService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.google.common.truth.Truth.assertThat;

@SpringBootTest(properties = "spring.profiles.active=test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SalvarEditoraUseCaseTest {
    @Autowired
    ConfiguraBaseEmMemoria configuraBaseEmMemoria;

    @Autowired
    EditoraService editoraService;

    @Autowired
    SalvarEditoraUseCase salvarEditoraUseCase;

    @BeforeAll
    public void setup() {
        configuraBaseEmMemoria.configurarBancoDeDados();
    }

    @Test
    void deveSalvarEditora() {
        var quantidadeEditoras = editoraService.buscarTodos().size();
        salvarEditoraUseCase.salvar(new Editora("MinhaEditoraCustomizada"));
        assertThat(editoraService.buscarTodos().size()).isEqualTo(quantidadeEditoras + 1);
    }
}
