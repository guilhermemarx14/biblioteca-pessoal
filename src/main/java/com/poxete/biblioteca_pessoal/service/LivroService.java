package com.poxete.biblioteca_pessoal.service;

import com.poxete.biblioteca_pessoal.exception.LivroNaoEncontradoException;
import com.poxete.biblioteca_pessoal.model.*;
import com.poxete.biblioteca_pessoal.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.poxete.biblioteca_pessoal.config.Constantes.MENSAGEM_EXCEPTION_LIVRO_NAO_ENCONTRADO;

@Service
public class LivroService {
    @Autowired
    LivroRepository livroRepository;

    public List<Livro> buscarTodos() {
        return livroRepository.findAll();
    }

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> buscarPorTitulo(String titulo) {
        return livroRepository.buscarPorTituloLike(titulo);
    }

    public List<Livro> buscarTodosPorListAutor(List<Autor> autores) {
        return livroRepository.buscarTodosPorAutor(autores);
    }

    public List<Livro> buscarTodosPorGenero(List<Genero> genero) {
        return livroRepository.buscarTodosPorGenero(genero);
    }

    public List<Livro> buscarTodosPorEditora(List<Editora> editoras) {
        return livroRepository.findAllByEditoraIn(editoras);
    }

    public List<Livro> buscarTodosPorLocalizacao(List<Localizacao> localizacoes) {
        return livroRepository.findAllByLocalizacaoIn(localizacoes);
    }

    public Livro buscarPorId(Integer id) {
        return livroRepository.findById(id).orElseThrow(() -> new LivroNaoEncontradoException(MENSAGEM_EXCEPTION_LIVRO_NAO_ENCONTRADO.formatted(id)));
    }
}
