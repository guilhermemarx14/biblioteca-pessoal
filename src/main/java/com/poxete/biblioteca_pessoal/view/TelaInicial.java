package com.poxete.biblioteca_pessoal.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import static com.poxete.biblioteca_pessoal.config.Constantes.*;

public class TelaInicial extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Cria o botão
        Button button = new Button("Clique para imprimir Hello World");

        // Ação do botão: imprime "Hello World" no console do Spring
        button.setOnAction(e ->
            System.out.println("Hello World!")
        );

        // Layout StackPane
        StackPane root = new StackPane();
        root.getChildren().add(button);

        // Cena
        Scene scene = new Scene(root, LANGURA_PADRAO, ALTURA_PADRAO);

        // Configura o título da janela
        primaryStage.setTitle(NOME_APLICACAO);

        // Define a cena e exibe a janela
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
