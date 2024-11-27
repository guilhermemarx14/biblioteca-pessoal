package com.poxete.biblioteca_pessoal.usecase;

import com.poxete.biblioteca_pessoal.model.Livro;
import com.poxete.biblioteca_pessoal.service.*;
import com.poxete.biblioteca_pessoal.service.dto.LivroCompletoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.poxete.biblioteca_pessoal.model.mapper.LivroMapper.transformarLivroCompletoDTOEmLivro;

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

    /**
     * Salva um livro e todos os seus relacionamentos.
     *
     * @param livrocompletoDTO dados do livro a ser salvo
     * @return o livro salvo
     */
    public Livro salvarLivro(LivroCompletoDTO livrocompletoDTO) {
        var livroASerSalvo = transformarLivroCompletoDTOEmLivro(livrocompletoDTO);
        livroASerSalvo.setTitulo(livrocompletoDTO.getTitulo());

        livroASerSalvo.setAutores(autorService.salvar(livroASerSalvo.getAutores()));
        livroASerSalvo.setGeneros(generoService.salvarTodos(livroASerSalvo.getGeneros()));
        livroASerSalvo.setEditora(editoraService.salvar(livroASerSalvo.getEditora()));
        livroASerSalvo.setLocalizacao(localizacaoService.salvar(livroASerSalvo.getLocalizacao()));
        return livroService.salvar(livroASerSalvo);
    }
}
