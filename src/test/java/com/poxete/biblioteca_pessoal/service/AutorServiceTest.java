package com.poxete.biblioteca_pessoal.service;

import com.poxete.biblioteca_pessoal.model.Autor;
import com.poxete.biblioteca_pessoal.repository.AutorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class AutorServiceTest {
    @Mock
    AutorRepository autorRepository;

    @InjectMocks
    AutorService autorService;

    @Test
    void deveSalvarAutor() {
        var autorASerSalvo = new Autor("Teste", null);
        var autorSalvo = new Autor(1, "Teste", null);

        when(autorRepository.save(autorASerSalvo)).thenReturn(autorSalvo);

        assertThat(autorService.salvar(autorASerSalvo)).isEqualTo(autorSalvo);
    }

    @Test
    void deveBuscarPorIdSucesso() {
        var autorSalvo = new Autor(1, "Teste", null);

        when(autorRepository.findById(1)).thenReturn(Optional.of(autorSalvo));

        assertThat(autorService.buscarPorId(1)).isEqualTo(autorSalvo);
    }

    @Test
    void deveBuscarPorIdFalha() {
        when(autorRepository.findById(1)).thenReturn(Optional.empty());

        assertThat(autorService.buscarPorId(1)).isNull();
    }
}
