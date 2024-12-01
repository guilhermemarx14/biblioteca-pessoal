package com.poxete.biblioteca_pessoal.usecase.obter;

import com.poxete.biblioteca_pessoal.model.Autor;
import com.poxete.biblioteca_pessoal.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.poxete.biblioteca_pessoal.utils.Utils.capitalizarPalavras;

@Component
public class ObterDetalhesAutorUseCase {
    @Autowired
    AutorService autorService;

    public Autor obterDetalhesAutor(String nome) {
        var autor = autorService.buscarPorParteNome(nome).getFirst();
        autor.setNome(capitalizarPalavras(autor.getNome()));
        autor.setFavorito(autor.getFavorito() != null && autor.getFavorito());

        return autor;
    }

    public List<Autor> obterTodosOsAutores() {
        return autorService.buscarTodos();
    }
}
