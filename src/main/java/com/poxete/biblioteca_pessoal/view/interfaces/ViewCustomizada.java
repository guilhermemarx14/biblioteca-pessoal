package com.poxete.biblioteca_pessoal.view.interfaces;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class ViewCustomizada<T extends Estado> {

    public abstract void setEstado(T estado);

    public abstract void setPrimaryStage(Stage primaryStage);

    public abstract Stage getPrimaryStage();

    public abstract void show(FXMLLoader loader) throws IOException;

    public void onExit() {
        // Fecha a janela JavaFX
        Platform.runLater(() -> {
            if (getPrimaryStage() != null) {
                getPrimaryStage().close();
            }
        });
    }
}
