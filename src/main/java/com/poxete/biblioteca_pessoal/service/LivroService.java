package com.poxete.biblioteca_pessoal.service;

import com.poxete.biblioteca_pessoal.model.*;
import com.poxete.biblioteca_pessoal.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    LivroRepository livroRepository;

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro buscarPorId(Integer id) {
        return livroRepository.findById(id).orElse(null);
    }

    public List<Livro> buscarTodos() {
        return livroRepository.findAll();
    }

    public List<Livro> buscarPorTitulo(String titulo) {
        return livroRepository.buscarPorTituloLike(titulo);
    }

    public List<Livro> buscarTodosPorAutor(List<Autor> autores) {
        return livroRepository.buscarTodosPorAutor(autores);
    }

    public List<Livro> buscarTodosPorGenero(List<Genero> generos) {
        return livroRepository.buscarTodosPorGenero(generos);
    }

    public List<Livro> buscarTodosPorEditora(List<Editora> editoras) {
        return livroRepository.findAllByEditoraIn(editoras);
    }

    public List<Livro> buscarTodosPorLocalizacao(List<Localizacao> localizacoes) {
        return livroRepository.findAllByLocalizacaoIn(localizacoes);
    }
}
