package com.poxete.biblioteca_pessoal.view.interfaces;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;

public interface ViewCustomizada<T extends Estado> {

    void setEstado(T estado);

    void setPrimaryStage(Stage primaryStage);

    Stage getPrimaryStage();

    void show(FXMLLoader loader) throws IOException;

    default void onExit() {
        // Fecha a janela JavaFX
        Platform.runLater(() -> {
            if (getPrimaryStage() != null) {
                getPrimaryStage().close();
            }
        });
    }
}
