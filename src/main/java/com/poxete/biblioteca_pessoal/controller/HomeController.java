package com.poxete.biblioteca_pessoal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("mensagem", "Bem-vindo ao Spring Boot a biblioteca pessoal!");
        return "home";  // Nome do template que será renderizado
    }
}
