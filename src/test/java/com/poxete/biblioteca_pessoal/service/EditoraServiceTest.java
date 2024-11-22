package com.poxete.biblioteca_pessoal.service;

import com.poxete.biblioteca_pessoal.model.Editora;
import com.poxete.biblioteca_pessoal.repository.EditoraRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class EditoraServiceTest {
    @Mock
    EditoraRepository editoraRepository;

    @InjectMocks
    EditoraService editoraService;

    @Test
    void deveSalvarEditora() {
        var editoraASerSalva = new Editora("Teste");
        var editoraSalva = new Editora(1, "Teste");

        when(editoraRepository.save(editoraASerSalva)).thenReturn(editoraSalva);

        assertThat(editoraService.salvar(editoraASerSalva)).isEqualTo(
                editoraSalva);
    }

    @Test
    void deveBuscarEditoraPorId() {
        var editoraSalva = new Editora(1, "Teste");

        when(editoraRepository.findById(1)).thenReturn(Optional.of(editoraSalva));

        assertThat(editoraService.buscarPorId(1)).isEqualTo(editoraSalva);
    }

    @Test
    void deveBuscarEditoraPorIdNaoEncontrado() {
        when(editoraRepository.findById(1)).thenReturn(Optional.empty());

        assertThat(editoraService.buscarPorId(1)).isNull();
    }

    @Test
    void deveBuscarTodasEditoras() {
        var editoraSalva = new Editora(1, "Teste");

        when(editoraRepository.findAll()).thenReturn(List.of(editoraSalva));

        assertThat(editoraService.obterTodos()).containsExactly(editoraSalva);
    }
}
