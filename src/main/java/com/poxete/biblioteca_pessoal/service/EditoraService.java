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

    public Editora salvar(Editora editora) {
        var editoraExistente = editoraRepository.findByNome(editora.getNome());

        return editoraExistente.orElse(editoraRepository.save(editora));
    }

    public Editora buscarPorId(Integer id) {
        return editoraRepository.findById(id).orElse(null);
    }

    public List<Editora> obterTodos() {
        return editoraRepository.findAll();
    }

    public List<Editora> buscarPorNome(String nome) {
        return editoraRepository.findAllByNomeLike(nome);
    }
}
