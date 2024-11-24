package com.poxete.biblioteca_pessoal.controller;

import com.poxete.biblioteca_pessoal.usecase.BuscarLivrosUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListagemLivrosController {
    @Autowired
    BuscarLivrosUseCase buscarLivrosUseCase;

    @GetMapping("/listar")
    public String exibirMensagem(Model model) {
        var livros = buscarLivrosUseCase.obterTodosOsLivros();

        model.addAttribute("livros", livros);
        model.addAttribute("mensagem", "Lista de livros");
        return "listagemlivros";
    }
}
