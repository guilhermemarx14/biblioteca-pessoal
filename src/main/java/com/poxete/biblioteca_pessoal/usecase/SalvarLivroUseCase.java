package com.poxete.biblioteca_pessoal.usecase;

import com.poxete.biblioteca_pessoal.model.Autor;
import com.poxete.biblioteca_pessoal.model.Genero;
import com.poxete.biblioteca_pessoal.model.Livro;
import com.poxete.biblioteca_pessoal.service.*;
import com.poxete.biblioteca_pessoal.service.dto.LivroCompletoDTO;
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

        livroASerSalvo.setAutores(autorService.salvar(livroASerSalvo.getAutores()));
        livroASerSalvo.setGeneros(generoService.salvar(livroASerSalvo.getGeneros()));
        livroASerSalvo.setEditora(editoraService.salvar(livroASerSalvo.getEditora()));
        livroASerSalvo.setLocalizacao(localizacaoService.salvar(livroASerSalvo.getLocalizacao()));
        return livroService.salvar(livroASerSalvo);
    }

    public List<Genero> obterTodosOsGeneros() {
        return generoService.buscarTodos();
    }

    public List<Autor> obterTodosOsAutores() {
        return autorService.buscarTodos();
    }
}
