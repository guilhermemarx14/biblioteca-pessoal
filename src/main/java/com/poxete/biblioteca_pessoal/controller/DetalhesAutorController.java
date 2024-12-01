package com.poxete.biblioteca_pessoal.controller;

import com.poxete.biblioteca_pessoal.usecase.obter.ObterDetalhesAutorUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DetalhesAutorController {
    @Autowired
    ObterDetalhesAutorUseCase obterDetalhesAutorUseCase;

    @GetMapping("/detalhesAutor")
    public String obterDetalhesAutor(@RequestParam("nome") String nome, Model model) {
        model.addAttribute("autor", obterDetalhesAutorUseCase.obterDetalhesAutor(nome));

        return "detalhesautor";
    }
}
