package com.poxete.biblioteca_pessoal.usecase;

import com.poxete.biblioteca_pessoal.model.Autor;
import com.poxete.biblioteca_pessoal.service.WikipediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuscarDadosAutorUseCase {
    @Autowired
    WikipediaService wikipediaService;

    /**
     * Busca os dados pro autor
     *
     * @param autor o autor
     * @return uma tripla com Nome, nomesAlternativos e biografia (se existir)
     */
    public Autor buscarDadosAutor(Autor autor) {
        autor.setBiografia(wikipediaService.obterBiografia(autor.getNome()));
        return autor;
    }

}
