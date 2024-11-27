package com.poxete.biblioteca_pessoal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetalhesAutorController {

    @GetMapping("/detalhesAutor/{nome}")
    public String obterDetalhesAutor(@PathVariable("nome") String nome) {
        return "texto";
    }
}
