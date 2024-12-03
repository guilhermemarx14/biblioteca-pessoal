package com.poxete.biblioteca_pessoal.usecase.obter;

import com.poxete.biblioteca_pessoal.model.Livro;
import com.poxete.biblioteca_pessoal.service.*;
import com.poxete.biblioteca_pessoal.service.dto.LivroCompletoDTO;
import com.poxete.biblioteca_pessoal.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

import static com.poxete.biblioteca_pessoal.config.Constantes.NAO_FORAM_ENCONTRADOS_DADOS_AUTOR;
import static com.poxete.biblioteca_pessoal.model.mapper.LivroMapper.transformarLivroEmLivroCompletoDTO;

@Component
public class ObterDetalhesLivroUseCase {

    @Autowired
    LivroService livroService;

    @Autowired
    AutorService autorService;

    @Autowired
    GeneroService generoService;

    @Autowired
    EditoraService editoraService;

    @Autowired
    WikipediaService wikipediaService;

    public LivroCompletoDTO obterDetalhesLivro(Integer id) {
        var entidade = livroService.buscarPorId(id);
        if (entidade.getSinopse() == null || entidade.getSinopse().isEmpty() || entidade.getSinopse().equals(NAO_FORAM_ENCONTRADOS_DADOS_AUTOR)) {
            entidade.setSinopse(wikipediaService.obterDadosWikipedia(entidade.getTitulo()));
            livroService.salvar(entidade);
        }

        var livro = transformarLivroEmLivroCompletoDTO(entidade);

        livro.setTitulo(Utils.capitalizarPalavras(livro.getTitulo()));
        livro.setEditora(Utils.capitalizarPalavras(livro.getEditora()));
        livro.setLocalizacao(Utils.capitalizarPalavras(livro.getLocalizacao()));

        livro.setSinopse(wikipediaService.obterDadosWikipedia(livro.getTitulo()));
        return livro;
    }

    public List<Livro> obterTodosOsLivros() {
        var livros = livroService.buscarTodos();
        livros.forEach(l -> l.setTitulo(Utils.capitalizarPalavras(l.getTitulo())));
        return livroService.buscarTodos()
                .stream()
                .sorted(Comparator.comparing(Livro::getDataLeitura, Comparator.nullsLast(Comparator.reverseOrder())))
                .toList();
    }

    public List<Livro> obterLivrosPorBusca(String chave) {
        var query = Utils.prepararLikeParaBuscaGenerica(chave);

        var autores = autorService.buscarPorParteNome(query);
        var generos = generoService.encontrarPorParteNome(query);
        var editoras = editoraService.buscarPorParteNome(query);

        var livros = livroService.buscarPorTitulo(query);
        livros.addAll(livroService.buscarTodosPorAutor(autores));
        livros.addAll(livroService.buscarTodosPorGenero(generos));
        livros.addAll(livroService.buscarTodosPorEditora(editoras));


        livros.forEach(l -> l.setTitulo(Utils.capitalizarPalavras(l.getTitulo())));
        return livros;
    }
}
