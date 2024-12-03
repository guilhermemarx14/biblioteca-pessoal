package com.poxete.biblioteca_pessoal.usecase.obter;

import com.poxete.biblioteca_pessoal.model.Autor;
import com.poxete.biblioteca_pessoal.service.AutorService;
import com.poxete.biblioteca_pessoal.service.WikipediaService;
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
        autor.setFavorito(autor.getFavorito() != null && autor.getFavorito());

        if (autor.getBiografia() == null || autor.getBiografia().equals("Não foram encontrados dados para o autor.")) {
            autor.setBiografia(wikipediaService.obterDadosWikipedia(autor.getNome()));
            autorService.salvar(autor);
        }

        return autor;
    }

    public List<Autor> obterTodosOsAutores() {
        return autorService.buscarTodos();
    }
}
