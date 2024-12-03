package com.poxete.biblioteca_pessoal.service;

import com.poxete.biblioteca_pessoal.exception.LivroNaoEncontradoException;
import com.poxete.biblioteca_pessoal.model.Autor;
import com.poxete.biblioteca_pessoal.model.Editora;
import com.poxete.biblioteca_pessoal.model.Genero;
import com.poxete.biblioteca_pessoal.model.Livro;
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

    public List<Livro> buscarTodosPorFavorito() {
        return livroRepository.findAllByFavorito(true);
    }

    public List<Livro> buscarTodosPorLidoENaoFavorito() {
        return livroRepository.findAllByLidoAndFavorito(true, false);
    }

    public Livro buscarPorId(Integer id) {
        return livroRepository.findById(id).orElseThrow(() -> new LivroNaoEncontradoException(MENSAGEM_EXCEPTION_LIVRO_NAO_ENCONTRADO.formatted(id)));
    }

    public void excluirLivroPorId(Integer id) {
        livroRepository.deleteById(id);
    }

    public List<Livro> buscarTodosPorAutor(List<Autor> autor) {
        return livroRepository.buscarTodosPorAutor(autor);

    }

    public List<Livro> buscarTodosPorGenero(List<Genero> genero) {
        return livroRepository.buscarTodosPorGenero(genero);
    }

    public List<Livro> buscarTodosPorEditora(List<Editora> editora) {
        return livroRepository.buscarTodosPorEditora(editora);
    }
}
