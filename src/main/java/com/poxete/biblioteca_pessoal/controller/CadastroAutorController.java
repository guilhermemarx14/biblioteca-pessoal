package com.poxete.biblioteca_pessoal.controller;

import com.poxete.biblioteca_pessoal.service.dto.AutorDTO;
import com.poxete.biblioteca_pessoal.usecase.SalvarAutorUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CadastroAutorController {
    @Autowired
    SalvarAutorUseCase salvarAutorUseCase;

    @GetMapping("/cadastroAutor")
    public String exibirFormulario(Model model) {
        model.addAttribute("autor", new AutorDTO());
        return "cadastroautor";
    }

    @PostMapping("/salvar-autor")
    public String salvarAutor(@ModelAttribute AutorDTO autorDTO, Model model) {
        model.addAttribute("mensagem", "Autor salvo com sucesso!");
        salvarAutorUseCase.salvarAutor(autorDTO);
        return "redirect:/";
    }
}
