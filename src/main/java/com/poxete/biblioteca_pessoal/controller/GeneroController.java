package com.poxete.biblioteca_pessoal.controller;

import com.poxete.biblioteca_pessoal.model.Genero;
import com.poxete.biblioteca_pessoal.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/genero")
public class GeneroController {
    @Autowired
    GeneroService generoService;

    @GetMapping("/{id}")
    public ResponseEntity<Genero> buscaGenero(@PathVariable("id") Integer id) {
        var genero = generoService.buscarPorId(id);
        return genero == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(genero);
    }

    @GetMapping("/obterTodos")
    public ResponseEntity<List<Genero>> obterTodosGeneros() {
        return generoService.obterTodos() == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(generoService.obterTodos());
    }

    @PostMapping("/salvar")
    public ResponseEntity<Genero> salvarGenero(@RequestBody Genero genero) {
        var generoSalvo = generoService.salvar(genero);
        return ResponseEntity.ok(generoSalvo);
    }

}
