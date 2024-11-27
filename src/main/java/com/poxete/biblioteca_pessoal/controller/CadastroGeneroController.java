package com.poxete.biblioteca_pessoal.controller;

import com.poxete.biblioteca_pessoal.model.Genero;
import com.poxete.biblioteca_pessoal.usecase.SalvarGeneroUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CadastroGeneroController {
    @Autowired
    SalvarGeneroUseCase salvarGeneroUseCase;

    /**
     * Exibe o formulário de cadastro de gênero.
     *
     * @param model Model do Spring MVC que contém os dados do formulário.
     * @return Nome da view que será renderizada.
     */
    @GetMapping("/cadastroGenero")
    public String exibirFormulario(Model model) {
        model.addAttribute("genero", new Genero());
        return "cadastrogenero";
    }

    /**
     * Salva um novo gênero e redireciona para a página inicial.
     *
     * @param genero Objeto Genero que contém as informações a serem salvas.
     * @param model  Model do Spring MVC que contém os dados do formulário.
     * @return Redireciona para a página inicial após salvar o gênero.
     */
    @PostMapping("/salvar-genero")
    public String salvarGenero(@ModelAttribute Genero genero, Model model) {
        model.addAttribute("mensagem", "Genero salvo com sucesso!");
        salvarGeneroUseCase.salvarGenero(genero);
        return "redirect:/";
    }
}
