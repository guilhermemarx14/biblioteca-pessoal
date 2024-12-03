package com.poxete.biblioteca_pessoal.controller;

import com.poxete.biblioteca_pessoal.usecase.obter.ObterDetalhesAutorUseCase;
import com.poxete.biblioteca_pessoal.utils.IgnorarNoCoverage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@IgnorarNoCoverage
@Controller
public class ListagemAutoresController {

    @Autowired
    ObterDetalhesAutorUseCase obterDetalhesAutorUseCase;

    private static final String MENSAGEM = "mensagem";

    @GetMapping("/listarAutores")
    public String exibirMensagem(Model model) {
        var autores = obterDetalhesAutorUseCase.obterTodosOsAutores();

        model.addAttribute("autores", autores);
        model.addAttribute(MENSAGEM, "Lista de autores");
        return "listagemautores";
    }
}
