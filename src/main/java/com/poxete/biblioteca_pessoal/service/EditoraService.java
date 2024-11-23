package com.poxete.biblioteca_pessoal.service;

import com.poxete.biblioteca_pessoal.model.Editora;
import com.poxete.biblioteca_pessoal.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditoraService {

    @Autowired
    EditoraRepository editoraRepository;

    public List<Editora> buscarPorNome(String nome) {
        return editoraRepository.findAllByNomeLike(nome);
    }
}
