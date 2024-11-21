package com.poxete.biblioteca_pessoal.service;

import com.poxete.biblioteca_pessoal.model.Editora;
import com.poxete.biblioteca_pessoal.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditoraService {

    @Autowired
    EditoraRepository editoraRepositoryRepository;

    public Editora salvar(Editora editora){
        var editoraExistente = editoraRepositoryRepository.findByNome(editora.getNome());

        return editoraExistente.orElse(editoraRepositoryRepository.save(editora));
    }

    public Editora buscarPorId(Integer id){
        return editoraRepositoryRepository.findById(id).orElse(null);
    }

    public List<Editora> obterTodos(){
        return editoraRepositoryRepository.findAll();
    }
}
