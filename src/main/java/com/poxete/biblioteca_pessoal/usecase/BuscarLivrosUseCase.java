package com.poxete.biblioteca_pessoal.usecase;

import com.poxete.biblioteca_pessoal.model.Livro;
import com.poxete.biblioteca_pessoal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.poxete.biblioteca_pessoal.utils.Utils.prepararLikeParaBuscaGenerica;

@Component
public class BuscarLivrosUseCase {
    @Autowired
    LivroService livroService;

    @Autowired
    GeneroService generoService;

    @Autowired
    AutorService autorService;

    @Autowired
    EditoraService editoraService;

    @Autowired
    LocalizacaoService localizacaoService;

    public List<Livro> buscarLivroPorTitulo(String titulo) {
        return livroService.buscarPorTitulo(prepararLikeParaBuscaGenerica(titulo));
    }

    public List<Livro> obterTodosOsLivros() {
        return livroService.buscarTodos()
                .stream()
                .sorted(Comparator.comparing(Livro::getDataLeitura, Comparator.nullsLast(Comparator.reverseOrder())))
                .toList();
    }

    public List<Livro> obterLivroBuscaGenerica(String query) {
        var chave = prepararLikeParaBuscaGenerica(query);

        Set<Livro> livros = new HashSet<>(livroService.buscarPorTitulo(chave));
        livros.addAll(livroService.buscarTodosPorAutor(autorService.buscarPorNome(chave)));
        livros.addAll(livroService.buscarTodosPorEditora(editoraService.buscarPorNome(chave)));
        livros.addAll(livroService.buscarTodosPorGenero(generoService.buscarPorNomeLike(chave)));
        livros.addAll(livroService.buscarTodosPorLocalizacao(localizacaoService.buscarLocalizacaoPorDescricao(chave)));

        return livros.stream().toList();
    }

}
