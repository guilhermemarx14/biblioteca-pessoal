package com.poxete.biblioteca_pessoal.controller;

import com.poxete.biblioteca_pessoal.usecase.obter.ObterRecomendacoesUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecomendacaoLivroController {
    @Autowired
    ObterRecomendacoesUseCase obterRecomendacoesUseCase;

    @GetMapping("/recomendacaoLivro")
    public String exibirMensagem(Model model) {
        model.addAttribute("titulo", "Recomendações");
        model.addAttribute("texto", obterRecomendacoesUseCase.obterRecomendacoes());
        return "recomendacaolivro";
    }
}
