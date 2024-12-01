package com.poxete.biblioteca_pessoal.usecase.salvar;

import com.poxete.biblioteca_pessoal.model.Autor;
import com.poxete.biblioteca_pessoal.service.AutorService;
import com.poxete.biblioteca_pessoal.service.WikipediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class SalvarAutorUseCase {
    @Autowired
    AutorService autorService;

    @Autowired
    WikipediaService wikipediaService;

    public Set<Autor> salvarLista(List<Autor> autores) {
        autores.forEach(autor -> {
            autor.setBiografia(obterBiografia(autor.getNome()));
            autor.setFavorito(autor.getFavorito() != null && autor.getFavorito());
        });

        return autorService.salvarLista(autores);
    }

    private String obterBiografia(String nome) {
        try {
            return wikipediaService.obterDadosWikipedia(nome);
        } catch (Exception e) {
            return "Não foram encontrados dados para o autor.";
        }
    }
}
