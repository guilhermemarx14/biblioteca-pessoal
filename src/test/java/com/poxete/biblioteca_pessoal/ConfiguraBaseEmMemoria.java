package com.poxete.biblioteca_pessoal;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class ConfiguraBaseEmMemoria {
    @Autowired
    Flyway flyway;

    public void configurarBancoDeDados() {
        flyway.clean();
        flyway.migrate();
    }
}
