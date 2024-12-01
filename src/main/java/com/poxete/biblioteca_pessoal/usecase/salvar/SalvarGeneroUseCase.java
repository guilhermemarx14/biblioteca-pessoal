package com.poxete.biblioteca_pessoal.usecase.salvar;

import com.poxete.biblioteca_pessoal.model.Genero;
import com.poxete.biblioteca_pessoal.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalvarGeneroUseCase {
    @Autowired
    GeneroService generoService;


    public Genero salvarGenero(Genero genero) {
        return generoService.salvar(genero);
    }

    public List<Genero> salvarLista(List<Genero> generos) {
        return generoService.salvarLista(generos);
    }

    public List<Genero> obterTodosOsGeneros() {
        return generoService.buscarTodos();
    }
}
