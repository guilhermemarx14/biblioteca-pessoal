package com.poxete.biblioteca_pessoal.service;

import com.poxete.biblioteca_pessoal.model.Autor;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

@SpringBootTest(properties = "spring.profiles.active=test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AutorServiceTest {
    @Autowired
    Flyway flyway;

    @Autowired
    AutorService autorService;

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String datasourceUsername;

    @Value("${spring.datasource.password}")
    private String datasourcePassword;

    @BeforeAll
    public void configurarBancoDeDados() {
        // Executa as migrações padrão
        flyway.clean();
        flyway.migrate();

        // Executa o script de carga adicional para os testes
        try (Connection connection = DriverManager.getConnection(
                datasourceUrl,
                datasourceUsername,
                datasourcePassword
        )) {
            ScriptUtils.executeSqlScript(connection, new ClassPathResource("db/test-data/T1__carga_testes.sql"));
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao executar script de carga de dados", e);
        }
    }

    @Test
    void deveSalvarUmAutor() {
        var autorSalvo = autorService.salvar(new Autor("Stephenie Meyer", List.of()));

        var autorBuscado = autorService.buscarPorId(autorSalvo.getId());

        assertThat(autorSalvo).isEqualTo(autorBuscado);
    }
}
