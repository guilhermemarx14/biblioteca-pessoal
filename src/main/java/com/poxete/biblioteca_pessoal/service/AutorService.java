package com.poxete.biblioteca_pessoal.service;

import com.poxete.biblioteca_pessoal.model.Autor;
import com.poxete.biblioteca_pessoal.repository.AutorRepository;
import com.poxete.biblioteca_pessoal.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AutorService {
    @Autowired
    AutorRepository autorRepository;

    public Autor salvar(Autor autor) {
        var autorExistente = autorRepository.buscarPorNomeCompleto(autor.getNome().trim().toUpperCase());
        return autorExistente.orElseGet(() -> autorRepository.save(autor));

    }

    public Set<Autor> salvarLista(List<Autor> lista) {
        var autoresSalvos = new HashSet<Autor>();
        lista.forEach(autor -> autoresSalvos.add(salvar(autor)));
        return autoresSalvos;
    }

    public List<Autor> buscarPorParteNome(String nome) {
        return autorRepository.buscarPorParteNome(Utils.prepararLikeParaBuscaGenerica(nome));
    }

    public List<Autor> buscarTodos() {
        var todos = autorRepository.findAll();
        todos.forEach(a -> a.setNome(Utils.capitalizarPalavras(a.getNome())));
        return todos;
    }

    public List<Autor> buscarPorFavorito() {
        return autorRepository.findAllByFavorito(true);
    }
}
