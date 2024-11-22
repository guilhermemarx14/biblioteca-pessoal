package com.poxete.biblioteca_pessoal.service;

import com.poxete.biblioteca_pessoal.model.Localizacao;
import com.poxete.biblioteca_pessoal.repository.LocalizacaoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class LocalizacaoServiceTest {
    @Mock
    LocalizacaoRepository localizacaoRepository;

    @InjectMocks
    LocalizacaoService localizacaoService;

    @Test
    void deveSalvarLocalizacao() {
        var localizacao = new Localizacao(1, "Prateleira A1");

        when(localizacaoRepository.save(localizacao)).thenReturn(localizacao);

        var localizacaoSalva = localizacaoService.salvar(localizacao);

        assertThat(localizacaoSalva).isEqualTo(localizacao);
    }

    @Test
    void deveBuscarLocalizacaoPorId() {
        var localizacao = new Localizacao(1, "Prateleira A1");

        when(localizacaoRepository.findById(1)).thenReturn(Optional.of(
                localizacao));

        assertThat(localizacaoService.buscarPorId(1)).isEqualTo(localizacao);
    }

    @Test
    void deveBuscarLocalizacaoPorIdNaoEncontrado() {
        when(localizacaoRepository.findById(1)).thenReturn(Optional.empty());

        assertThat(localizacaoService.buscarPorId(1)).isNull();
    }
}