package com.poxete.biblioteca_pessoal.service;

import com.poxete.biblioteca_pessoal.model.Genero;
import com.poxete.biblioteca_pessoal.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {
    @Autowired
    GeneroRepository generoRepository;

    public Genero salvar(Genero genero) {
        var generoExistente = generoRepository.findByNome(genero.getNome());
        return generoExistente.orElse(generoRepository.save(genero));
    }

    public Genero buscarPorId(Integer id) {
        return generoRepository.findById(id).orElse(null);
    }

    public List<Genero> obterTodos() {
        return generoRepository.findAll();
    }

    public List<Genero> buscarPorNomeLike(String nome) {
        return generoRepository.findAllByNomeLike(nome);
    }
}
