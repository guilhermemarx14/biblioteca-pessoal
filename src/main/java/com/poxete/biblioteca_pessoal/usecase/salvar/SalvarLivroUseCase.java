package com.poxete.biblioteca_pessoal.usecase.salvar;

import com.poxete.biblioteca_pessoal.model.Autor;
import com.poxete.biblioteca_pessoal.model.Livro;
import com.poxete.biblioteca_pessoal.service.GeminiService;
import com.poxete.biblioteca_pessoal.service.LivroService;
import com.poxete.biblioteca_pessoal.service.dto.LivroCompletoDTO;
import com.poxete.biblioteca_pessoal.utils.Utils;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;

import static com.poxete.biblioteca_pessoal.config.Constantes.PROMT_SINOPSE;
import static com.poxete.biblioteca_pessoal.model.mapper.LivroMapper.transformarLivroCompletoDTOEmLivro;

@Component
public class SalvarLivroUseCase {

    @Autowired
    GeminiService geminiService;

    @Autowired
    LivroService livroService;

    @Autowired
    SalvarAutorUseCase salvarAutorUseCase;

    @Autowired
    SalvarGeneroUseCase salvarGeneroUseCase;

    @Autowired
    SalvarEditoraUseCase salvarEditoraUseCase;

    @Autowired
    SalvarLocalizacaoUseCase salvarLocalizacaoUseCase;

    @Transactional
    public Livro salvarLivro(LivroCompletoDTO livrocompletoDTO) {
        var livroASerSalvo = transformarLivroCompletoDTOEmLivro(livrocompletoDTO);
        livroASerSalvo.setTitulo(livrocompletoDTO.getTitulo());

        livroASerSalvo.setAutores(new ArrayList<>(salvarAutorUseCase.salvarLista(livroASerSalvo.getAutores())));
        livroASerSalvo.setGeneros(salvarGeneroUseCase.salvarLista(livroASerSalvo.getGeneros()));
        livroASerSalvo.setEditora(salvarEditoraUseCase.salvar(livroASerSalvo.getEditora()));
        livroASerSalvo.setLocalizacao(salvarLocalizacaoUseCase.salvar(livroASerSalvo.getLocalizacao()));
        if (Boolean.TRUE.equals(livroASerSalvo.getLido()) && livroASerSalvo.getDataLeitura() == null) {
            livroASerSalvo.setDataLeitura(LocalDate.now());
        }
        try {
            livroASerSalvo.setSinopse(geminiService.realizarConsulta(PROMT_SINOPSE.formatted(
                    livroASerSalvo.getTitulo(),
                    Utils.formatarListaComE(livroASerSalvo.getAutores().stream().map(Autor::getNome).toList())
            )));
        } catch (FeignException e) {
            livroASerSalvo.setSinopse("Não foi possivel obter sinopse");
        }


        return livroService.salvar(livroASerSalvo);
    }

    public void atualizarStatusLivro(Integer id, Boolean lido, Boolean favorito) {
        var livro = livroService.buscarPorId(id);
        livro.setLido(lido);
        livro.setFavorito(favorito);
        livroService.salvar(livro);
    }
}
