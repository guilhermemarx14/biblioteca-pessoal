package com.poxete.biblioteca_pessoal.view.telainicial;

import com.poxete.biblioteca_pessoal.view.componentes.IconeComLabel;
import com.poxete.biblioteca_pessoal.view.interfaces.ViewCustomizada;
import jakarta.annotation.PreDestroy;
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
    private TelaInicialEstado estado;
    private Stage primaryStage;


    @Override
    public void show(FXMLLoader loader) throws IOException {
        GridPane meuGrid = loader.load();

        var vBoxLivros = montarVBox(estado.getIconesComLabel().get(0));
        var vBoxAutores = montarVBox(estado.getIconesComLabel().get(1));
        var vBoxPesquisar = montarVBox(estado.getIconesComLabel().get(2));


        meuGrid.add(vBoxLivros, 0, 0);
        meuGrid.add(vBoxAutores, 1, 0);
        meuGrid.add(vBoxPesquisar, 0, 1);

        Scene scene = new Scene(meuGrid, LANGURA_PADRAO, ALTURA_PADRAO);

        primaryStage.setTitle(NOME_APLICACAO);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox montarVBox(IconeComLabel iconeComLabel) {
        Label labelIcone = new Label(iconeComLabel.icone());
        labelIcone.setStyle("-fx-font-size: 80px; -fx-text-fill: blue;");

        Label labelNome = new Label(iconeComLabel.label());
        labelNome.setStyle("-fx-font-size: 15px;");

        VBox vBox = new VBox(iconeComLabel.espacamento());

        vBox.getChildren().addAll(labelIcone, labelNome);
        vBox.setAlignment(Pos.CENTER);
        vBox.setOnMouseClicked(iconeComLabel.handler());
        return vBox;
    }

    @PreDestroy
    public void fechar() {
        super.onExit();
    }

    @Override
    public void setEstado(TelaInicialEstado estado) {
        this.estado = estado;
    }

    @Override
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public Stage getPrimaryStage() {
        return this.primaryStage;
    }

}
