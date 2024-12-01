package com.poxete.biblioteca_pessoal.usecase.obter;

import com.poxete.biblioteca_pessoal.model.Livro;
import com.poxete.biblioteca_pessoal.service.LivroService;
import com.poxete.biblioteca_pessoal.service.WikipediaService;
import com.poxete.biblioteca_pessoal.service.dto.LivroCompletoDTO;
import com.poxete.biblioteca_pessoal.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

import static com.poxete.biblioteca_pessoal.model.mapper.LivroMapper.transformarLivroEmLivroCompletoDTO;
import static com.poxete.biblioteca_pessoal.utils.Utils.prepararLikeParaBuscaGenerica;

@Component
public class ObterDetalhesLivroUseCase {

    @Autowired
    LivroService livroService;

    @Autowired
    WikipediaService wikipediaService;

    public LivroCompletoDTO obterDetalhesLivro(Integer id) {//TODO: teste unitario
        var livro = transformarLivroEmLivroCompletoDTO(livroService.buscarPorId(id));

        livro.setTitulo(Utils.capitalizarPalavras(livro.getTitulo()));
        livro.setEditora(Utils.capitalizarPalavras(livro.getEditora()));
        livro.setLocalizacao(Utils.capitalizarPalavras(livro.getLocalizacao()));

        return livro;
    }

    public List<Livro> buscarLivroPorTitulo(String titulo) {
        return livroService.buscarPorTitulo(prepararLikeParaBuscaGenerica(titulo));
    }

    public List<Livro> obterTodosOsLivros() {
        var livros = livroService.buscarTodos();
        livros.forEach(l -> l.setTitulo(Utils.capitalizarPalavras(l.getTitulo())));
        return livroService.buscarTodos()
                .stream()
                .sorted(Comparator.comparing(Livro::getDataLeitura, Comparator.nullsLast(Comparator.reverseOrder())))
                .toList();
    }
}
