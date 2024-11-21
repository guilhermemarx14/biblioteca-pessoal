package com.poxete.biblioteca_pessoal.view.interfaces;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Getter
@Setter
public abstract class ViewCustomizada<T extends Estado> {
    T estado;
    public abstract void show(Stage primaryStage, FXMLLoader loader) throws IOException;
}
