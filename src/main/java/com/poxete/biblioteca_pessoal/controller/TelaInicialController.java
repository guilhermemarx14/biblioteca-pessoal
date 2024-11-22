package com.poxete.biblioteca_pessoal.controller;

import com.poxete.biblioteca_pessoal.config.SpringFXMLLoaderConfig;
import com.poxete.biblioteca_pessoal.service.LivroService;
import com.poxete.biblioteca_pessoal.view.componentes.IconeComLabel;
import com.poxete.biblioteca_pessoal.view.telainicial.TelaInicialEstado;
import com.poxete.biblioteca_pessoal.view.telainicial.TelaInicialView;
import javafx.application.Application;
import javafx.stage.Stage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@Component
public class TelaInicialController extends Application {
    @Autowired
    SpringFXMLLoaderConfig springFXMLLoaderConfig;

    @Autowired
    TelaInicialView telaInicialView;

    @Autowired
    LivroService livroService;

    @Override
    public void start(Stage primaryStage) throws Exception {

        telaInicialView.setEstado(new TelaInicialEstado(List.of(
                new IconeComLabel(
                        "Livros Cadastrados",
                        "\uD83D\uDCDA",
                        5,
                        event -> log.info(livroService.buscarPorTitulo("  senhor  an"))
                ), new IconeComLabel(
                        "Autores Cadastrados",
                        "\uD83E\uDDD1\u200D\uD83D\uDCBB",
                        5,
                        event -> log.info("Você clicou em Autores Cadastrados")
                ), new IconeComLabel("Pesquisar", "\uD83D\uDD0D", 5, event -> log.info("Voce clicou em Pesquisar"))
        )));

        telaInicialView.show(primaryStage, springFXMLLoaderConfig.load("/fxml/telainicialview.fxml"));
    }
}
