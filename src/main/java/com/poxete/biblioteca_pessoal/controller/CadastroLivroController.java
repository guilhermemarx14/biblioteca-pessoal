package com.poxete.biblioteca_pessoal.controller;

import com.poxete.biblioteca_pessoal.service.dto.LivroCompletoDTO;
import com.poxete.biblioteca_pessoal.usecase.SalvarLivroUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CadastroLivroController {
    @Autowired
    SalvarLivroUseCase salvarLivroUseCase;

    @GetMapping("/cadastroLivro")
    public String exibirFormulario(Model model) {
        model.addAttribute("livro", new LivroCompletoDTO());
        model.addAttribute("autores", salvarLivroUseCase.obterTodosOsAutores());
        model.addAttribute("generos", salvarLivroUseCase.obterTodosOsGeneros());
        return "cadastrolivro";
    }

    @PostMapping("/salvar-livro")
    public String salvarLivro(@ModelAttribute LivroCompletoDTO livroCompletoDTO, Model model) {
        model.addAttribute("mensagem", "Livro salvo com sucesso!");
        salvarLivroUseCase.salvarLivro(livroCompletoDTO);
        return "redirect:/";
    }
}
