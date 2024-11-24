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

    public List<Editora> buscarPorParteNome(String nome) {
        return editoraRepository.buscarTodosPorNome(nome);
    }

    public Editora obterOuSalvar(Editora editora) {
        var editoraExistente = editoraRepository.findById(editora.getNome());
        return editoraExistente.orElseGet(() -> editoraRepository.save(editora));
    }
}
