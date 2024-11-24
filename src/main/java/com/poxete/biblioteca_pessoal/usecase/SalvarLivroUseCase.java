package com.poxete.biblioteca_pessoal.usecase;

import com.poxete.biblioteca_pessoal.model.Livro;
import com.poxete.biblioteca_pessoal.service.AutorService;
import com.poxete.biblioteca_pessoal.service.GeneroService;
import com.poxete.biblioteca_pessoal.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalvarLivroUseCase {
    @Autowired
    LivroService livroService;

    @Autowired
    AutorService autorService;

    @Autowired
    GeneroService generoService;

    public Livro salvarLivro(Livro livroASerSalvo) {
        livroASerSalvo.setAutores(autorService.salvar(livroASerSalvo.getAutores()));
        livroASerSalvo.setGeneros(generoService.obterOuSalvar(livroASerSalvo.getGeneros()));
        return livroService.salvar(livroASerSalvo);
    }
}
