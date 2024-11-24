package com.poxete.biblioteca_pessoal.service;

import com.poxete.biblioteca_pessoal.model.Autor;
import com.poxete.biblioteca_pessoal.repository.AutorRepository;
import com.poxete.biblioteca_pessoal.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutorService {
    @Autowired
    AutorRepository autorRepository;

    public List<Autor> salvar(List<Autor> autores) {
        final List<Autor> autoresSalvos = new ArrayList<>();
        autores.forEach(autor -> {
            var autorExistente = autorRepository.buscarPorNomeCompleto(Utils.prepararLikeParaBuscaGenerica(autor.getNome()));
            autoresSalvos.add(autorExistente.orElseGet(() -> autorRepository.save(autor)));
        });
        return autoresSalvos;
    }

    public List<Autor> buscarPorParteNome(String nome) {
        return autorRepository.buscarPorParteNome(nome);
    }
}
