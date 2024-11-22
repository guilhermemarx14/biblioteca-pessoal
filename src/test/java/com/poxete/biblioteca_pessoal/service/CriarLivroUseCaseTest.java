package com.poxete.biblioteca_pessoal.service;

import com.poxete.biblioteca_pessoal.model.*;
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
class CriarLivroUseCaseTest {
    @Autowired
    Flyway flyway;

    @Autowired
    AutorService autorService;

    @Autowired
    EditoraService editoraService;

    @Autowired
    GeneroService generoService;

    @Autowired
    LocalizacaoService localizacaoService;

    @Autowired
    LivroService livroService;

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
    void deveSalvarUmLivroNovo() {
        //criando o autor
        var autorSalvo = autorService.salvar(new Autor("Stephenie Meyer", List.of()));

        var autorBuscado = autorService.buscarPorId(autorSalvo.getId());

        assertThat(autorSalvo).isEqualTo(autorBuscado);

        //criando a editora
        var editoraSalva = editoraService.salvar(new Editora("Intrinseca"));

        var editoraBuscada = editoraService.buscarPorId(editoraSalva.getId());

        assertThat(editoraSalva).isEqualTo(editoraBuscada);

        //criando o genero
        var generoSalvo = generoService.salvar(new Genero("Romance"));

        var generoBuscado = generoService.buscarPorId(generoSalvo.getId());

        assertThat(generoSalvo).isEqualTo(generoBuscado);

        var localizacaoSalva = localizacaoService.salvar(new Localizacao("Prateleira A1"));

        var localizacaoBuscada = localizacaoService.buscarPorId(localizacaoSalva.getId());

        assertThat(localizacaoSalva).isEqualTo(localizacaoBuscada);

        //criando o livro
        var livroNovo = new Livro(
                "Eclipse",
                2014,
                List.of(generoSalvo),
                List.of(autorSalvo),
                editoraSalva,
                localizacaoSalva,
                1
        );

        var livroSalvo = livroService.salvar(livroNovo);

        var livroBuscado = livroService.buscarPorId(livroSalvo.getId());

        assertThat(livroSalvo).isEqualTo(livroBuscado);
    }

}
