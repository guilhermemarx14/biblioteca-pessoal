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

    public List<Genero> salvarLista(List<Genero> generos) {
        var generosSalvos = new ArrayList<Genero>();
        generos.forEach(genero -> generosSalvos.add(salvar(genero)));
        return generosSalvos;
    }


    public Genero salvar(Genero genero) {
        var generoExistente = generoRepository.encontrarPorNome(genero.getNome());
        return generoExistente.orElse(generoRepository.save(genero));
    }


    public List<Genero> buscarTodos() {
        var todos = generoRepository.findAll();
        todos.forEach(g -> g.setNome(Utils.capitalizarPalavras(g.getNome())));
        return todos;
    }

    public List<Genero> encontrarPorParteNome(String parteNome) {
        return generoRepository.encontrarPorParteNome(parteNome);
    }

}
