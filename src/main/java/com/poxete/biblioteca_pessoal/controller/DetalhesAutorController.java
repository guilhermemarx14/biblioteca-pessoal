package com.poxete.biblioteca_pessoal.controller;

import com.poxete.biblioteca_pessoal.model.Autor;
import com.poxete.biblioteca_pessoal.usecase.obter.ObterDetalhesAutorUseCase;
import com.poxete.biblioteca_pessoal.usecase.salvar.SalvarAutorUseCase;
import com.poxete.biblioteca_pessoal.utils.IgnorarNoCoverage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@IgnorarNoCoverage
@Controller
public class DetalhesAutorController {
    @Autowired
    ObterDetalhesAutorUseCase obterDetalhesAutorUseCase;

    @Autowired
    SalvarAutorUseCase salvarAutorUseCase;

    @GetMapping("/detalhesAutor")
    public String obterDetalhesAutor(@RequestParam("nome") String nome, Model model) {
        model.addAttribute("autor", obterDetalhesAutorUseCase.obterDetalhesAutor(nome));

        return "detalhesautor";
    }

    @PostMapping("/atualizarFavoritoAutor")
    public String salvarAutor(@ModelAttribute Autor autor, Model model) {
        model.addAttribute("mensagem", "Livro salvo com sucesso!");
        salvarAutorUseCase.atualizarFavoritoAutor(autor.getId(), autor.getFavorito());
        return "redirect:/";
    }
}
