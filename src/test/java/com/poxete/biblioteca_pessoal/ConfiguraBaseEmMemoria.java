package com.poxete.biblioteca_pessoal;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@Profile("test")
public class ConfiguraBaseEmMemoria {
    @Autowired
    Flyway flyway;

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String datasourceUsername;

    @Value("${spring.datasource.password}")
    private String datasourcePassword;

    public void configurarBancoDeDados() {
        // Executa as migrações padrão
        flyway.clean();
        flyway.migrate();

        // Executa o script de carga adicional para os testes
        try (Connection connection = DriverManager.getConnection(datasourceUrl, datasourceUsername, datasourcePassword)) {
            ScriptUtils.executeSqlScript(connection, new ClassPathResource("db/test-data/T1__carga_testes.sql"));
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao executar script de carga de dados", e);
        }
    }
}
