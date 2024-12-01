package com.poxete.biblioteca_pessoal.controller;

import com.poxete.biblioteca_pessoal.usecase.deletar.DeletarLivrosUseCase;
import com.poxete.biblioteca_pessoal.usecase.obter.ObterDetalhesLivroUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ListagemLivrosController {
    @Autowired
    ObterDetalhesLivroUseCase obterDetalhesLivroUseCase;

    @Autowired
    DeletarLivrosUseCase deletarLivrosUseCase;

    @GetMapping("/listar")
    public String exibirMensagem(Model model) {
        var livros = obterDetalhesLivroUseCase.obterTodosOsLivros();

        model.addAttribute("livros", livros);
        model.addAttribute("mensagem", "Lista de livros");
        return "listagemlivros";
    }

    @DeleteMapping("/excluirLivro")
    public ResponseEntity<String> excluirLivro(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {//todo: fazer esse metodo
        try {
            deletarLivrosUseCase.deletarLivroPorId(id);
            redirectAttributes.addFlashAttribute("mensagem", "Livro excluído com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao excluir o livro: " + e.getMessage());
        }
        return ResponseEntity.ok("redirect:/home");
    }
}
