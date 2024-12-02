package com.poxete.biblioteca_pessoal.controller;

import com.poxete.biblioteca_pessoal.service.dto.LivroCompletoDTO;
import com.poxete.biblioteca_pessoal.usecase.obter.ObterDetalhesLivroUseCase;
import com.poxete.biblioteca_pessoal.usecase.salvar.SalvarLivroUseCase;
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
public class DetalhesLivroController {
    @Autowired
    ObterDetalhesLivroUseCase obterDetalhesLivroUseCase;

    @Autowired
    SalvarLivroUseCase salvarLivroUseCase;

    @GetMapping("/detalhesLivro")
    public String obterDetalhesLivro(@RequestParam("id") Integer id, Model model) {
        var livro = obterDetalhesLivroUseCase.obterDetalhesLivro(id);
        model.addAttribute("livro", livro);
        model.addAttribute("lido", livro.getLido());
        model.addAttribute("favorito", livro.getFavorito());

        return "detalheslivro";
    }

    @PostMapping("/atualizarStatusLivro")
    public String salvarLivro(@ModelAttribute LivroCompletoDTO livroCompletoDTO, Model model) {
        model.addAttribute("mensagem", "Livro salvo com sucesso!");
        salvarLivroUseCase.atualizarStatusLivro(livroCompletoDTO.getId(), livroCompletoDTO.getLido(), livroCompletoDTO.getFavorito());
        return "redirect:/";
    }
}
