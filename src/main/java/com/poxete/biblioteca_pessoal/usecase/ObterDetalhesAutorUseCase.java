package com.poxete.biblioteca_pessoal.usecase;

import com.poxete.biblioteca_pessoal.model.Autor;
import com.poxete.biblioteca_pessoal.service.AutorService;
import com.poxete.biblioteca_pessoal.service.WikipediaService;
import com.poxete.biblioteca_pessoal.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.poxete.biblioteca_pessoal.utils.Utils.capitalizarPalavras;

@Component
public class ObterDetalhesAutorUseCase {
    @Autowired
    AutorService autorService;

    @Autowired
    WikipediaService wikipediaService;


    public Autor obterDetalhesAutor(String nome) {
        var autor = autorService.buscarPorParteNome(nome).getFirst();
        autor.setNome(capitalizarPalavras(autor.getNome()));
        autor.getOutrosNomes().add(autor.getNome());
        autor.setOutrosNomes(autor.getOutrosNomes().stream().map(Utils::capitalizarPalavras).toList());
        autor.setBiografia(wikipediaService.obterDadosWikipedia(autor.getNome()));
        autor.setFavorito(autor.getFavorito() != null && autor.getFavorito());
        return autor;
    }

    /**
     * Obtém todos os autores cadastrados.
     *
     * @return uma lista contendo todos os autores
     */
    public List<Autor> obterTodosOsAutores() {
        return autorService.buscarTodos();
    }
}
