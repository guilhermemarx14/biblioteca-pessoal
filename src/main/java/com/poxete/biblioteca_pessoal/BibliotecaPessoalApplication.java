package com.poxete.biblioteca_pessoal;

import com.poxete.biblioteca_pessoal.view.TelaInicial;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.poxete.biblioteca_pessoal.repository")
public class BibliotecaPessoalApplication{

    public static void main(String[] args) {
        // Inicia o Spring Boot
        SpringApplication.run(BibliotecaPessoalApplication.class, args);

        // Inicia a interface JavaFX com a tela inicial
        launchJavaFXApp();
    }

    public static void launchJavaFXApp() {
        // Lança a tela principal do JavaFX
        Application.launch(TelaInicial.class);
    }

}
