package com.poxete.biblioteca_pessoal.config;

import javafx.fxml.FXMLLoader;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;

@AllArgsConstructor
public class SpringFXMLLoaderConfig {

    final ApplicationContext context;

    public FXMLLoader load(String fxmlFile) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        loader.setControllerFactory(context::getBean);
        return loader;
    }
}
