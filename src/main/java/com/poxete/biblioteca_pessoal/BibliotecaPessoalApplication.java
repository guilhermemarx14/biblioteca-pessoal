package com.poxete.biblioteca_pessoal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.poxete.biblioteca_pessoal.repository")
public class BibliotecaPessoalApplication{

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BibliotecaPessoalApplication.class, args);
        launchJavaFXApp(context);
    }

    public static void launchJavaFXApp(ConfigurableApplicationContext context) {
        SpringJavaFXApplication.launch(SpringJavaFXApplication.class, context);
    }

    @EventListener({ContextClosedEvent.class, ContextStoppedEvent.class})
    public void onContextClosed() {
        SpringJavaFXApplication.shutdownJavaFX();
    }
}
