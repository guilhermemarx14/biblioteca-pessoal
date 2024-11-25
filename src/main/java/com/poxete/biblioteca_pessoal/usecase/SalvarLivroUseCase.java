package com.poxete.biblioteca_pessoal.usecase;

import com.poxete.biblioteca_pessoal.controller.dto.LivroCompletoDTO;
import com.poxete.biblioteca_pessoal.model.Autor;
import com.poxete.biblioteca_pessoal.model.Genero;
import com.poxete.biblioteca_pessoal.model.Livro;
import com.poxete.biblioteca_pessoal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalvarLivroUseCase {
    @Autowired
    LivroService livroService;

    @Autowired
    AutorService autorService;

    @Autowired
    GeneroService generoService;

    @Autowired
    EditoraService editoraService;

    @Autowired
    LocalizacaoService localizacaoService;

    public Livro salvarLivro(LivroCompletoDTO livrocompletoDTO) {
        var livroASerSalvo = new Livro(livrocompletoDTO);
        livroASerSalvo.setTitulo(livrocompletoDTO.getTitulo());

        livroASerSalvo.setAutores(autorService.obterOuSalvar(livroASerSalvo.getAutores()));
        livroASerSalvo.setGeneros(generoService.obterOuSalvar(livroASerSalvo.getGeneros()));
        livroASerSalvo.setEditora(editoraService.obterOuSalvar(livroASerSalvo.getEditora()));
        livroASerSalvo.setLocalizacao(localizacaoService.obterOuSalvar(livroASerSalvo.getLocalizacao()));
        return livroService.salvar(livroASerSalvo);
    }

    public List<Genero> obterTodosOsGeneros() {
        return generoService.buscarTodos();
    }

    public List<Autor> obterTodosOsAutores() {
        return autorService.buscarTodos();
    }
}
