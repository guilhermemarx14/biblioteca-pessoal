package com.poxete.biblioteca_pessoal.controller;

import com.poxete.biblioteca_pessoal.usecase.ObterDetalhesLivroUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DetalhesLivroController {
    @Autowired
    ObterDetalhesLivroUseCase obterDetalhesLivroUseCase;

    @GetMapping("/detalhesLivro")
    public String obterDetalhesLivro(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("livro", obterDetalhesLivroUseCase.obterDetalhesLivro(id));

        return "detalheslivro";
    }
}
