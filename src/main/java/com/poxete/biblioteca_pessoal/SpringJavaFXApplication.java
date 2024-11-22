package com.poxete.biblioteca_pessoal;

import com.poxete.biblioteca_pessoal.controller.TelaInicialController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;

public class SpringJavaFXApplication extends Application {
    private static ConfigurableApplicationContext context;

    public static void launch(Class<? extends Application> appClass, ConfigurableApplicationContext appContext) {
        context = appContext;
        Application.launch(appClass);
    }

    @Override
    public void start(Stage stage) throws Exception {
        TelaInicialController telaInicial = context.getBean(TelaInicialController.class);
        telaInicial.start(stage);
    }

    public static void shutdownJavaFX() {
        Platform.exit();
    }
}
