package com.poxete.biblioteca_pessoal.view.telainicial;

import com.poxete.biblioteca_pessoal.view.componentes.IconeComLabel;
import com.poxete.biblioteca_pessoal.view.interfaces.ViewCustomizada;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.poxete.biblioteca_pessoal.config.Constantes.*;

@Component
public class TelaInicialView extends ViewCustomizada<TelaInicialEstado> {

    @Override
    public void show(Stage primaryStage, FXMLLoader loader) throws IOException {
        GridPane meuGrid = loader.load();

        var vBoxLivros = montarVBox(getEstado().getIconesComLabel().get(0));
        var vBoxAutores = montarVBox(getEstado().getIconesComLabel().get(1));



        meuGrid.add(vBoxLivros, 0, 0);
        meuGrid.add(vBoxAutores, 1, 0);

        Scene scene = new Scene(meuGrid, LANGURA_PADRAO, ALTURA_PADRAO);

        primaryStage.setTitle(NOME_APLICACAO);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox montarVBox(IconeComLabel iconeComLabel) {
        Label labelIcone = new Label(iconeComLabel.icone());
        labelIcone.setStyle("-fx-font-size: 80px; -fx-text-fill: blue;");

        Label labelNome = new Label(iconeComLabel.label());
        labelNome.setStyle("-fx-font-size: 20px;");

        VBox vBox = new VBox(iconeComLabel.espacamento());

        vBox.getChildren().addAll(labelIcone, labelNome);
        vBox.setAlignment(Pos.CENTER);

        return vBox;
    }

}
