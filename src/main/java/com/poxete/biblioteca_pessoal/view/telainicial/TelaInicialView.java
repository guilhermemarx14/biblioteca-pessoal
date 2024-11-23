package com.poxete.biblioteca_pessoal.view.telainicial;

import com.poxete.biblioteca_pessoal.view.interfaces.ViewCustomizada;
import jakarta.annotation.PreDestroy;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.IOException;

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
        VBox vBoxContainer = loader.load();

        Button botaoListarLivrosCadastrados = (Button) vBoxContainer.getChildren().get(0);
        botaoListarLivrosCadastrados.setOnAction(estado.listarLivrosCadastradosHandler);

        Button botaoCadastrarNovoLivro = (Button) vBoxContainer.getChildren().get(1);
        botaoCadastrarNovoLivro.setOnAction(estado.cadastrarNovoLivroHandler);


        Scene scene = new Scene(vBoxContainer, LANGURA_PADRAO, ALTURA_PADRAO);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    @PreDestroy
    public void fechar() {
        this.onExit();
    }

}
