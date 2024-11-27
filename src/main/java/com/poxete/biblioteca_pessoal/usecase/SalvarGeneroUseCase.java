package com.poxete.biblioteca_pessoal.usecase;

import com.poxete.biblioteca_pessoal.model.Genero;
import com.poxete.biblioteca_pessoal.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalvarGeneroUseCase {
    @Autowired
    GeneroService generoService;

    /**
     * Salva um novo gênero na base de dados.
     *
     * @param genero o gênero a ser salvo
     * @return o g nero salvo, com o id gerado
     */
    public Genero salvarGenero(Genero genero) {
        return generoService.salvarTodos(genero);
    }

    /**
     * Obtém todos os gêneros disponíveis na base de dados.
     *
     * @return uma lista de todos os gêneros
     */
    public List<Genero> obterTodosOsGeneros() {
        return generoService.buscarTodos();
    }
}
