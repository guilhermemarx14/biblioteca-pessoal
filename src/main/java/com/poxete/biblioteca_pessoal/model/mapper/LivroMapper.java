package com.poxete.biblioteca_pessoal.model.mapper;


import com.poxete.biblioteca_pessoal.model.*;
import com.poxete.biblioteca_pessoal.service.dto.LivroCompletoDTO;
import com.poxete.biblioteca_pessoal.service.dto.LivroResumoDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LivroMapper {

    public static Livro transformarLivroCompletoDTOEmLivro(LivroCompletoDTO dto) {
        if (dto == null) {
            return null;
        }

        return Livro.builder()
                .titulo(dto.getTitulo())
                .lido(!dto.getLido())
                .generos(dto.getGeneros().stream().map(Genero::new).toList())
                .autores(dto.getAutores().stream().map(Autor::new).toList())
                .editora(new Editora(dto.getEditora()))
                .localizacao(new Localizacao(dto.getLocalizacao()))
                .quantidade(dto.getQuantidade())
                .classificacao(dto.getClassificacao())
                .anoPublicacao(dto.getAnoPublicacao())
                .dataLeitura(dto.getDataLeitura())
                .comentario(dto.getComentario())
                .favorito(!dto.getFavorito())
                .build();
    }

    public static LivroCompletoDTO transformarLivroEmLivroCompletoDTO(Livro livro) {
        if (livro == null) {
            return null;
        }

        return LivroCompletoDTO.builder()
                .titulo(livro.getTitulo())
                .lido(livro.getLido())
                .generos(livro.getGeneros().stream().map(Genero::getNome).toList())
                .autores(livro.getAutores().stream().map(Autor::getNome).toList())
                .editora(livro.getEditora().getNome())
                .localizacao(livro.getLocalizacao().getDescricao())
                .quantidade(livro.getQuantidade())
                .classificacao(livro.getClassificacao())
                .dataLeitura(livro.getDataLeitura())
                .anoPublicacao(livro.getAnoPublicacao())
                .comentario(livro.getComentario())
                .favorito(livro.getFavorito())
                .build();
    }

    public static LivroResumoDTO transformarLivroEmLivroResumoDTO(Livro livro) {
        if (livro == null)
            return null;

        return LivroResumoDTO.builder()
                .id(livro.getId())
                .titulo(livro.getTitulo())
                .autores(livro.getAutores())
                .classificacao("*".repeat(Math.max(0, livro.getClassificacao())))
                .build();
    }
}