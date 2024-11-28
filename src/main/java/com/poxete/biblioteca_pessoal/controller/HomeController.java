package com.poxete.biblioteca_pessoal.controller;

import com.poxete.biblioteca_pessoal.usecase.ObterDetalhesAutorUseCase;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class HomeController {
    @Autowired
    ObterDetalhesAutorUseCase obterDetalhesAutorUseCase;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("titulo", "Biblioteca Pessoal");
        model.addAttribute("listaAutores", obterDetalhesAutorUseCase.obterTodosOsAutores());
        return "home";
    }

}
