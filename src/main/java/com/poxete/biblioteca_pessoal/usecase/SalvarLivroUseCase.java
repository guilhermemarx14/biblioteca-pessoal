package com.poxete.biblioteca_pessoal.usecase;

import com.poxete.biblioteca_pessoal.model.Livro;
import com.poxete.biblioteca_pessoal.service.*;
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

    @Autowired
    EditoraService editoraService;

    @Autowired
    LocalizacaoService localizacaoService;

    public Livro salvarLivro(Livro livroASerSalvo) {
        livroASerSalvo.setAutores(autorService.obterOuSalvar(livroASerSalvo.getAutores()));
        livroASerSalvo.setGeneros(generoService.obterOuSalvar(livroASerSalvo.getGeneros()));
        livroASerSalvo.setEditora(editoraService.obterOuSalvar(livroASerSalvo.getEditora()));
        livroASerSalvo.setLocalizacao(localizacaoService.obterOuSalvar(livroASerSalvo.getLocalizacao()));
        return livroService.salvar(livroASerSalvo);
    }
}
