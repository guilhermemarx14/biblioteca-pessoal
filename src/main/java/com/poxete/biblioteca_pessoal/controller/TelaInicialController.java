package com.poxete.biblioteca_pessoal.controller;

import com.poxete.biblioteca_pessoal.config.SpringFXMLLoaderConfig;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.poxete.biblioteca_pessoal.config.Constantes.*;


@Component
public class TelaInicialController extends Application {
    @Autowired
    SpringFXMLLoaderConfig springFXMLLoaderConfig;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = springFXMLLoaderConfig.load("/fxml/telainicial.fxml");
        GridPane meuGrid = loader.load();

        Label label = new Label("Hello");
        meuGrid.add( label, 0, 0);

        Scene scene = new Scene(meuGrid, LANGURA_PADRAO, ALTURA_PADRAO);

        primaryStage.setTitle(NOME_APLICACAO);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
