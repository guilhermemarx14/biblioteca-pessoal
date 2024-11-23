package com.poxete.biblioteca_pessoal.usecase;

import com.poxete.biblioteca_pessoal.model.Livro;
import com.poxete.biblioteca_pessoal.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalvarLivroUseCase {
    @Autowired
    LivroService livroService;

    public Livro salvarLivro(Livro livroASerSalvo) {
        return livroService.salvar(livroASerSalvo);
    }
}
