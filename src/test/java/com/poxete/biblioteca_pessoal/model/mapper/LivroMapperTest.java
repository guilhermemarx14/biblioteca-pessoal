package com.poxete.biblioteca_pessoal.model.mapper;

import com.poxete.biblioteca_pessoal.model.*;
import com.poxete.biblioteca_pessoal.service.dto.LivroCompletoDTO;
import com.poxete.biblioteca_pessoal.service.dto.LivroResumoDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

@ExtendWith(SpringExtension.class)
class LivroMapperTest {
    @Test
    void deveTransformarLivroCompletoDTOEmLivro() {
        // Dado
        LivroCompletoDTO dto = LivroCompletoDTO.builder()
                .id(1)
                .titulo("Livro de Teste")
                .lido(true)
                .generos("Fantasia;Aventura")
                .autores("Autor 1;Autor 2")
                .editora("Editora Exemplo")
                .localizacao("Estante 1")
                .quantidade(2)
                .classificacao(4)
                .anoPublicacao(2021)
                .dataLeitura(LocalDate.of(2023, 10, 1))
                .comentario("Comentário teste")
                .favorito(true)
                .sinopse("Sinopse de teste")
                .build();

        // Quando
        Livro livro = LivroMapper.transformarLivroCompletoDTOEmLivro(dto);

        // Então
        assertThat(livro).isNotNull();
        assertThat(livro.getTitulo()).isEqualTo("Livro de Teste");
        assertThat(livro.getLido()).isTrue();
        assertThat(livro.getGeneros()).hasSize(2);
        assertThat(livro.getGeneros().get(0).getNome()).isEqualTo("Fantasia");
        assertThat(livro.getAutores()).hasSize(2);
        assertThat(livro.getAutores().get(0).getNome()).isEqualTo("Autor 1");
        assertThat(livro.getEditora().getNome()).isEqualTo("Editora Exemplo");
        assertThat(livro.getLocalizacao().getDescricao()).isEqualTo("Estante 1");
    }

    @Test
    void deveTransformarLivroCompletoDTOEmLivroUmAutoreUmGenero() {
        // Dado
        LivroCompletoDTO dto = LivroCompletoDTO.builder()
                .id(1)
                .titulo("Livro de Teste")
                .lido(true)
                .generos("Fantasia")
                .autores("Autor 1")
                .editora("Editora Exemplo")
                .localizacao("Estante 1")
                .quantidade(2)
                .classificacao(4)
                .anoPublicacao(2021)
                .dataLeitura(LocalDate.of(2023, 10, 1))
                .comentario("Comentário teste")
                .favorito(true)
                .sinopse("Sinopse de teste")
                .build();

        // Quando
        Livro livro = LivroMapper.transformarLivroCompletoDTOEmLivro(dto);

        // Então
        assertThat(livro).isNotNull();
        assertThat(livro.getTitulo()).isEqualTo("Livro de Teste");
        assertThat(livro.getLido()).isTrue();
        assertThat(livro.getGeneros()).hasSize(1);
        assertThat(livro.getGeneros().get(0).getNome()).isEqualTo("Fantasia");
        assertThat(livro.getAutores()).hasSize(1);
        assertThat(livro.getAutores().get(0).getNome()).isEqualTo("Autor 1");
        assertThat(livro.getEditora().getNome()).isEqualTo("Editora Exemplo");
        assertThat(livro.getLocalizacao().getDescricao()).isEqualTo("Estante 1");
    }

    @Test
    void deveTransformarLivroEmLivroCompletoDTO() {
        // Dado
        Livro livro = Livro.builder()
                .id(1)
                .titulo("Livro de Teste")
                .lido(false)
                .generos(List.of(new Genero("Fantasia"), new Genero("Aventura")))
                .autores(List.of(new Autor("Autor 1", false), new Autor("Autor 2", false)))
                .editora(new Editora("Editora Exemplo"))
                .localizacao(new Localizacao("Estante 1"))
                .quantidade(3)
                .classificacao(4)
                .anoPublicacao(2020)
                .dataLeitura(LocalDate.of(2024, 1, 1))
                .comentario("Comentário de exemplo")
                .favorito(false)
                .sinopse("Uma sinopse de exemplo")
                .build();

        // Quando
        LivroCompletoDTO dto = LivroMapper.transformarLivroEmLivroCompletoDTO(livro);

        // Então
        assertThat(dto).isNotNull();
        assertThat(dto.getTitulo()).isEqualTo("Livro de Teste");
        assertThat(dto.getLido()).isFalse();
        assertThat(dto.getGeneros()).isEqualTo("Fantasia;Aventura");
        assertThat(dto.getAutores()).isEqualTo("Autor 1;Autor 2");
        assertThat(dto.getEditora()).isEqualTo("Editora Exemplo");
        assertThat(dto.getLocalizacao()).isEqualTo("Estante 1");
    }

    @Test
    void deveTransformarLivroEmLivroResumoDTO() {
        // Dado
        Livro livro = Livro.builder().titulo("Resumo do Livro").autores(List.of(new Autor("Autor Único", false))).classificacao(4).build();

        // Quando
        LivroResumoDTO resumoDTO = LivroMapper.transformarLivroEmLivroResumoDTO(livro);

        // Então
        assertThat(resumoDTO).isNotNull();
        assertThat(resumoDTO.getTitulo()).isEqualTo("Resumo do Livro");
        assertThat(resumoDTO.getAutores()).hasSize(1);
        assertThat(resumoDTO.getAutores().get(0).getNome()).isEqualTo("Autor Único");
        assertThat(resumoDTO.getClassificacao()).isEqualTo(4);
    }

    @Test
    void deveRetornarNuloQuandoDTOOuLivroForemNulos() {
        // Quando e Então
        assertThat(LivroMapper.transformarLivroCompletoDTOEmLivro(null)).isNull();
        assertThat(LivroMapper.transformarLivroEmLivroCompletoDTO(null)).isNull();
        assertThat(LivroMapper.transformarLivroEmLivroResumoDTO(null)).isNull();
    }
}
