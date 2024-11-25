package com.poxete.biblioteca_pessoal.service;

import com.poxete.biblioteca_pessoal.model.Genero;
import com.poxete.biblioteca_pessoal.repository.GeneroRepository;
import com.poxete.biblioteca_pessoal.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeneroService {
    @Autowired
    GeneroRepository generoRepository;


    public List<Genero> obterOuSalvar(List<Genero> generos) {
        var generosSalvos = new ArrayList<Genero>();
        generos.forEach(genero -> {
            var generoExistente = generoRepository.findbyId(Utils.prepararLikeParaBuscaGenerica(genero.getNome()));
            generosSalvos.add(generoExistente.orElse(generoRepository.save(genero)));
        });

        return generosSalvos;

    }

    public List<Genero> buscarPorParteNome(String nome) {
        return generoRepository.buscarPorNome(Utils.prepararLikeParaBuscaGenerica(nome));
    }

    public List<Genero> buscarTodos() {
        var todos = generoRepository.findAll();
        todos.forEach(g -> g.setNome(Utils.capitalizarPalavras(g.getNome())));
        return todos;
    }
}
