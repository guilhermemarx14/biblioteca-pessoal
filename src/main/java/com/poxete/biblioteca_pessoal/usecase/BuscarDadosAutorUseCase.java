package com.poxete.biblioteca_pessoal.usecase;

import com.poxete.biblioteca_pessoal.exception.AutorNaoEncontradoException;
import com.poxete.biblioteca_pessoal.model.Autor;
import com.poxete.biblioteca_pessoal.service.AutorService;
import com.poxete.biblioteca_pessoal.service.WikipediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.poxete.biblioteca_pessoal.config.Constantes.MENSAGEM_EXCEPTION_AUTOR_NAO_ENCONTRADO;
import static com.poxete.biblioteca_pessoal.utils.Utils.capitalizarPalavras;

@Component
public class BuscarDadosAutorUseCase {
    static final String BIOGRAFIA_NAO_ENCONTRADA = "Não foi possivel obter a biografia de %s";
    @Autowired
    WikipediaService wikipediaService;

    @Autowired
    AutorService autorService;


    /**
     * Busca os dados de um autor.
     *
     * @param autorNome nome do autor a ser buscado
     * @return o autor com a biografia preenchida
     * @throws AutorNaoEncontradoException se o autor n o for encontrado
     */
    public Autor buscarDadosAutor(String autorNome) {
        var autorExistente = autorService.buscarAutorPorId(autorNome);
        if (autorExistente == null) {
            throw new AutorNaoEncontradoException(MENSAGEM_EXCEPTION_AUTOR_NAO_ENCONTRADO.formatted(capitalizarPalavras(autorNome)));
        }
        try {
            var biografia = wikipediaService.obterDadosWikipedia(autorExistente.getNome());
            autorExistente.setBiografia(biografia);
        } catch (Exception e) {
            autorExistente.setBiografia(BIOGRAFIA_NAO_ENCONTRADA.formatted(capitalizarPalavras(autorNome)));
        }

        return autorExistente;
    }

}
