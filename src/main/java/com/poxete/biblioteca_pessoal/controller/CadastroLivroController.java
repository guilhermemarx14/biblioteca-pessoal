package com.poxete.biblioteca_pessoal.controller;

import com.poxete.biblioteca_pessoal.service.dto.LivroCompletoDTO;
import com.poxete.biblioteca_pessoal.usecase.obter.ObterDetalhesAutorUseCase;
import com.poxete.biblioteca_pessoal.usecase.salvar.SalvarGeneroUseCase;
import com.poxete.biblioteca_pessoal.usecase.salvar.SalvarLivroUseCase;
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

    @Autowired
    SalvarGeneroUseCase salvarGeneroUseCase;

    @Autowired
    ObterDetalhesAutorUseCase obterDetalhesAutorUseCase;

    /**
     * Exibe o formulário de cadastro de livro
     *
     * @param model objeto que representa a model do Spring
     * @return o nome da view que será renderizada
     */
    @GetMapping("/cadastroLivro")
    public String exibirFormulario(Model model) {
        model.addAttribute("livro", new LivroCompletoDTO());
        model.addAttribute("autores", obterDetalhesAutorUseCase.obterTodosOsAutores());
        model.addAttribute("generos", salvarGeneroUseCase.obterTodosOsGeneros());
        return "cadastrolivro";
    }

    /**
     * Salva um livro com todos os seus relacionamentos.
     *
     * @param livroCompletoDTO dados do livro a ser salvo
     * @param model            objeto que representa a model do Spring
     * @return o nome da view que será renderizada
     */
    @PostMapping("/salvarLivro")
    public String salvarLivro(@ModelAttribute LivroCompletoDTO livroCompletoDTO, Model model) {
        model.addAttribute("mensagem", "Livro salvo com sucesso!");
        salvarLivroUseCase.salvarLivro(livroCompletoDTO);
        return "redirect:/";
    }
}
