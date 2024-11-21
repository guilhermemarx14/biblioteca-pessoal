package com.poxete.biblioteca_pessoal.controller;

import com.poxete.biblioteca_pessoal.config.SpringFXMLLoaderConfig;
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

    @Override
    public void start(Stage primaryStage) throws Exception {

        telaInicialView.setEstado(new TelaInicialEstado(List.of(new IconeComLabel("Meus Livros", "\uD83D\uDCDA", 5),
                new IconeComLabel("Meus Autores", "\uD83E\uDDD1\u200D\uD83D\uDCBB",8))));
        telaInicialView.show(primaryStage, springFXMLLoaderConfig.load("/fxml/telainicialview.fxml"));
    }
}
