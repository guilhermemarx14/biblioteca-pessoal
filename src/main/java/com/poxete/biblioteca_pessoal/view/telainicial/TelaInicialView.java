package com.poxete.biblioteca_pessoal.view.telainicial;

import com.jfoenix.controls.JFXButton;
import com.poxete.biblioteca_pessoal.view.interfaces.ViewCustomizada;
import jakarta.annotation.PreDestroy;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

import static com.poxete.biblioteca_pessoal.config.Constantes.ALTURA_PADRAO;
import static com.poxete.biblioteca_pessoal.config.Constantes.LANGURA_PADRAO;

@Component
@Getter
@Setter
public class TelaInicialView implements ViewCustomizada<TelaInicialEstado> {
    private TelaInicialEstado estado;
    private Stage primaryStage;

    @Override
    public void show(FXMLLoader loader) throws IOException {
        FlowPane main = loader.load();
        main.setVgap(20);
        main.setHgap(20);

        JFXButton botaoListar = new JFXButton("Listar Livros Cadastrados");
        botaoListar.getStyleClass().add("button-raised");
        botaoListar.setOnAction(estado.listarLivrosCadastradosHandler);
        main.getChildren().add(botaoListar);

        JFXButton botaoSalvar = new JFXButton("Salvar Livro");
        botaoSalvar.getStyleClass().add("button-raised");
        botaoSalvar.setOnAction(estado.cadastrarNovoLivroHandler);
        main.getChildren().add(botaoSalvar);

        Scene scene = new Scene(main, LANGURA_PADRAO, ALTURA_PADRAO);
        scene.getStylesheets().add(Objects.requireNonNull(TelaInicialView.class.getResource("/css/styles.css")).toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    @PreDestroy
    public void fechar() {
        this.onExit();
    }

}
