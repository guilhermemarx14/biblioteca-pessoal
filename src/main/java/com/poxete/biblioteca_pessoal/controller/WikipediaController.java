package com.poxete.biblioteca_pessoal.controller;

import com.poxete.biblioteca_pessoal.model.Autor;
import com.poxete.biblioteca_pessoal.usecase.BuscarDadosAutorUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WikipediaController {

    @Autowired
    private BuscarDadosAutorUseCase buscarDadosAutorUseCase;

    @GetMapping("/shakespeare-biografia")
    public String getShakespeareBiografia() {
        var autor = new Autor("William Shakespeare", null, null);
        return buscarDadosAutorUseCase.buscarDadosAutor(autor).getBiografia();
    }
}