package com.poxete.biblioteca_pessoal.usecase.deletar;

import com.poxete.biblioteca_pessoal.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletarLivrosUseCase {
    @Autowired
    LivroService livroService;

    public void deletarLivroPorId(Integer id) {
        livroService.excluirLivroPorId(id);
    }
}
