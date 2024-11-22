package com.poxete.biblioteca_pessoal.service;

import com.poxete.biblioteca_pessoal.repository.GeneroRepository;
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
class GeneroServiceTest {
    @Mock
    GeneroRepository generoRepository;

    @InjectMocks
    GeneroService generoService;

    @Test
    void deveSalvarGenero() {
        var genero = new com.poxete.biblioteca_pessoal.model.Genero(1, "Teste");
        when(generoRepository.save(genero)).thenReturn(genero);

        assertThat(generoService.salvar(genero)).isEqualTo(genero);
    }

    @Test
    void deveBuscarGeneroPorId() {
        var genero = new com.poxete.biblioteca_pessoal.model.Genero(1, "Teste");
        when(generoRepository.findById(1)).thenReturn(Optional.of(genero));

        assertThat(generoService.buscarPorId(1)).isEqualTo(genero);
    }

    @Test
    void deveBuscarGeneroPorIdNaoEncontrado() {
        when(generoRepository.findById(1)).thenReturn(Optional.empty());

        assertThat(generoService.buscarPorId(1)).isNull();
    }

    @Test
    void deveBuscarTodosGeneros() {
        var genero = new com.poxete.biblioteca_pessoal.model.Genero(1, "Teste");
        when(generoRepository.findAll()).thenReturn(List.of(genero));

        assertThat(generoService.obterTodos()).containsExactly(genero);
    }
}
