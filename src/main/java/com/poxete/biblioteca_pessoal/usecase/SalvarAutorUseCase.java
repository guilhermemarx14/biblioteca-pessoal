package com.poxete.biblioteca_pessoal.usecase;

import com.poxete.biblioteca_pessoal.model.Autor;
import com.poxete.biblioteca_pessoal.model.mapper.AutorMapper;
import com.poxete.biblioteca_pessoal.service.AutorService;
import com.poxete.biblioteca_pessoal.service.dto.AutorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalvarAutorUseCase {
    @Autowired
    AutorService autorService;

    /**
     * Salva um autor a partir de um AutorDTO.
     *
     * @param autorDTO autor a ser salvo
     * @return o autor salvo
     */
    public Autor salvarAutor(AutorDTO autorDTO) {
        return autorService.salvar(AutorMapper.transformarAutorDTOemAutor(autorDTO));
    }

    /**
     * Obtém todos os autores cadastrados.
     *
     * @return uma lista contendo todos os autores
     */
    public List<Autor> obterTodosOsAutores() {
        return autorService.buscarTodos();
    }
}
