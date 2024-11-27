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


    /**
     * Salva todos os generos recebidos, caso o genero não exista ele é criado.
     *
     * @param generos lista de generos a serem salvos
     * @return lista com os generos salvos
     */
    public List<Genero> salvarTodos(List<Genero> generos) {
        var generosSalvos = new ArrayList<Genero>();
        generos.forEach(genero -> {
            var generoExistente = generoRepository.findbyId(Utils.prepararLikeParaBuscaGenerica(genero.getNome()));
            generosSalvos.add(generoExistente.orElse(generoRepository.save(genero)));
        });

        return generosSalvos;
    }

    /**
     * Salva o genero recebido, caso o genero não exista ele é criado.
     *
     * @param genero genero a ser salvo
     * @return o genero salvo
     */
    public Genero salvarTodos(Genero genero) {
        return salvarTodos(List.of(genero)).getFirst();
    }

    /**
     * Realiza uma busca de generos que contenham a string <code>nome</code> no seu nome.
     *
     * @param nome string a ser buscada
     * @return lista de generos que contenham <code>nome</code> no seu nome
     */
    public List<Genero> buscarPorParteNome(String nome) {
        return generoRepository.buscarPorNome(Utils.prepararLikeParaBuscaGenerica(nome));
    }

    /**
     * Busca todos os generos existentes.
     *
     * @return lista de todos os generos existentes, com os nomes formatados para
     * primeira letra maiúscula.
     */
    public List<Genero> buscarTodos() {
        var todos = generoRepository.findAll();
        todos.forEach(g -> g.setNome(Utils.capitalizarPalavras(g.getNome())));
        return todos;
    }
}
