package com.poxete.biblioteca_pessoal.usecase;

import com.poxete.biblioteca_pessoal.service.LivroService;
import com.poxete.biblioteca_pessoal.service.WikipediaService;
import com.poxete.biblioteca_pessoal.service.dto.LivroCompletoDTO;
import com.poxete.biblioteca_pessoal.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.poxete.biblioteca_pessoal.model.mapper.LivroMapper.transformarLivroEmLivroCompletoDTO;

@Component
public class ObterDetalhesLivroUseCase {

    @Autowired
    LivroService livroService;

    @Autowired
    WikipediaService wikipediaService;

    public LivroCompletoDTO obterDetalhesLivro(Integer id) {//TODO: teste unitario
        var livro = transformarLivroEmLivroCompletoDTO(livroService.buscarPorId(id));
        livro.setDadosWikipedia(wikipediaService.obterDadosWikipedia(livro.getTitulo()));

        livro.setTitulo(Utils.capitalizarPalavras(livro.getTitulo()));
        livro.setEditora(Utils.capitalizarPalavras(livro.getEditora()));
        livro.setLocalizacao(Utils.capitalizarPalavras(livro.getLocalizacao()));

        return livro;
    }
}
