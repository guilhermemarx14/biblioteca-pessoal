package com.poxete.biblioteca_pessoal.controller;

import com.poxete.biblioteca_pessoal.config.SpringFXMLLoaderConfig;
import com.poxete.biblioteca_pessoal.model.*;
import com.poxete.biblioteca_pessoal.service.AutorService;
import com.poxete.biblioteca_pessoal.service.EditoraService;
import com.poxete.biblioteca_pessoal.service.GeneroService;
import com.poxete.biblioteca_pessoal.service.LocalizacaoService;
import com.poxete.biblioteca_pessoal.view.componentes.IconeComLabel;
import com.poxete.biblioteca_pessoal.view.telainicial.TelaInicialEstado;
import com.poxete.biblioteca_pessoal.view.telainicial.TelaInicialView;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class TelaInicialController extends Application {
    @Autowired
    SpringFXMLLoaderConfig springFXMLLoaderConfig;

    @Autowired
    TelaInicialView telaInicialView;

    @Autowired
    GeneroService generoService;

    @Autowired
    EditoraService editoraService;

    @Autowired
    LocalizacaoService localizacaoService;

    @Autowired
    AutorService autorService;

    @Override
    public void start(Stage primaryStage) throws Exception {

        telaInicialView.setEstado(new TelaInicialEstado(List.of(new IconeComLabel("Livros Cadastrados", "\uD83D\uDCDA", 5, event -> System.out.println("Você clicou em Livros Cadastrados")),
                new IconeComLabel("Autores Cadastrados", "\uD83E\uDDD1\u200D\uD83D\uDCBB", 5, event -> System.out.println("Você clicou em Autores Cadastrados")),
                new IconeComLabel("Pesquisar", "\uD83D\uDD0D", 5, event -> System.out.println("Voce clicou em Pesquisar")))));

        telaInicialView.show(primaryStage, springFXMLLoaderConfig.load("/fxml/telainicialview.fxml"));
    }

    public void popular(){
        var genero = generoService.salvar(new Genero("Auto-ajuda"));
        var editora = editoraService.salvar(new Editora("Nacional"));
        var localizacao = localizacaoService.salvar(new Localizacao("Estante 1"));
        var autor = autorService.salvar(new Autor("Blenda Marcelletti de Oliveira", List.of("B. M. de Oliveira")));
        var livro= Livro.builder().anoPublicacao(2024).editora(editora).generos(List.of(genero)).localizacao(localizacao).quantidade(1).titulo("fazendo as pazes com a ansiedade").autores(List.of(autor)).build();
    }
}
