package com.poxete.biblioteca_pessoal.controller;

import com.poxete.biblioteca_pessoal.config.SpringFXMLLoaderConfig;
import com.poxete.biblioteca_pessoal.model.*;
import com.poxete.biblioteca_pessoal.usecase.BuscarLivrosUseCase;
import com.poxete.biblioteca_pessoal.usecase.SalvarLivroUseCase;
import com.poxete.biblioteca_pessoal.view.telainicial.TelaInicialEstado;
import com.poxete.biblioteca_pessoal.view.telainicial.TelaInicialView;
import javafx.application.Application;
import javafx.stage.Stage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Log4j2
@Component
public class TelaInicialController extends Application {
    @Autowired
    SpringFXMLLoaderConfig springFXMLLoaderConfig;

    @Autowired
    TelaInicialView telaInicialView;

    @Autowired
    BuscarLivrosUseCase buscarLivrosUseCase;

    @Autowired
    SalvarLivroUseCase salvarLivroUseCase;

    @Override
    public void start(Stage primaryStage) throws Exception {
        telaInicialView.setEstado(new TelaInicialEstado(e -> obterLivros(), e -> salvarLivro()));
        telaInicialView.setPrimaryStage(primaryStage);
        telaInicialView.show(springFXMLLoaderConfig.load("/fxml/telainicialview.fxml"));
    }

    void obterLivros() {
        log.info(buscarLivrosUseCase.obterTodosOsLivros());
    }

    void salvarLivro() {
        var nomeEditora = "nomeEditora";
        var nomeAutor = "nomeAutor";
        var genero = "genero";
        var localizacaoS = "localizacao";
        var titulo = "titulo";
        var anoPublicacao = 0;
        var generos = new Genero(genero);
        var autores = new Autor(nomeAutor, null);
        var editora = new Editora(nomeEditora);
        var localizacao = new Localizacao(localizacaoS);
        var quantidade = 0;
        var livro = new Livro(titulo, anoPublicacao, List.of(generos), List.of(autores), editora, localizacao, quantidade);
        livro.setClassificacao(3);
        livro.setDataLeitura(new Date(LocalDate.now().toEpochDay()));
        livro.setComentario("comentario");

        var livroSalvo = salvarLivroUseCase.salvarLivro(livro);

        log.info("Livro salvo: " + livroSalvo);
    }
}
