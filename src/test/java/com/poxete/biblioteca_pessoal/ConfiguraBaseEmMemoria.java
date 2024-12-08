package com.poxete.biblioteca_pessoal;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class ConfiguraBaseEmMemoria {
    @Autowired
    Flyway flyway;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void configurarBancoDeDados() {
        flyway.clean();
        flyway.migrate();
        inserirDados();
    }

    private void inserirDados() {
        jdbcTemplate.execute("INSERT INTO Editora (id, nome) VALUES (1, 'Vestígio')");
        jdbcTemplate.execute("INSERT INTO Editora (id, nome) VALUES (2, 'Prime')");
        jdbcTemplate.execute("INSERT INTO Editora (id, nome) VALUES (3, 'Nacional')");
        jdbcTemplate.execute("INSERT INTO Editora (id, nome) VALUES (4, 'Manuscrito')");
        jdbcTemplate.execute("INSERT INTO Editora (id, nome) VALUES (5, 'Paidós')");

        jdbcTemplate.execute("INSERT INTO Genero (id, nome) VALUES (1, 'Auto-ajuda')");
        jdbcTemplate.execute("INSERT INTO Genero (id, nome) VALUES (2, 'História')");
        jdbcTemplate.execute("INSERT INTO Genero (id, nome) VALUES (3, 'Poesia')");

        jdbcTemplate.execute("INSERT INTO Localizacao (id, descricao) VALUES (1, 'Estante A')");
        jdbcTemplate.execute("INSERT INTO Localizacao (id, descricao) VALUES (2, 'Estante B')");
        jdbcTemplate.execute("INSERT INTO Localizacao (id, descricao) VALUES (3, 'Estante C')");

        jdbcTemplate.execute(
                "INSERT INTO Autor (id, nome, favorito, biografia) VALUES (1, 'Christian Dunker', TRUE, 'Não foram encontrados dados para o autor.')");
        jdbcTemplate.execute(
                "INSERT INTO Autor (id, nome, favorito, biografia) VALUES (2, 'Cláudio thebas', FALSE, 'Não foram encontrados dados para o autor.')");
        jdbcTemplate.execute(
                "INSERT INTO Autor (id, nome, favorito, biografia) VALUES (3, 'João gouveia monteiro', TRUE, 'Não foram encontrados dados para o autor.')");
        jdbcTemplate.execute(
                "INSERT INTO Autor (id, nome, favorito, biografia) VALUES (4, 'blenda marcelletti de oliveira', FALSE, 'Não foram encontrados dados para o autor.')");
        jdbcTemplate.execute(
                "INSERT INTO Autor (id, nome, favorito, biografia) VALUES (5, 'Marcos Manoel', FALSE, 'Não foram encontrados dados para o autor.')");
        jdbcTemplate.execute(
                "INSERT INTO Autor (id, nome, favorito, biografia) VALUES (6, 'dra meg arroll', FALSE, 'Não foram encontrados dados para o autor.')");

        jdbcTemplate.execute(
                "INSERT INTO Livro (id, titulo, lido, ano_publicacao, editora_id, localizacao_id, quantidade, classificacao, data_leitura, comentario, favorito, sinopse) VALUES (1, 'flores e odores', true, 2019, 2, 1, 2, 5, '2023-10-15', 'Poesias.', TRUE, 'Sinopse de flores e odores')");
        jdbcTemplate.execute(
                "INSERT INTO Livro (id, titulo, lido, ano_publicacao, editora_id, localizacao_id, quantidade, classificacao, data_leitura, comentario, favorito, sinopse) VALUES (2, 'portugal 50 anos depois do 25 de abril', FALSE, 2024, 4, 2, 1, 0, '2023-10-15', 'Ler em breve.', FALSE, 'Sinopse de portugal 50 anos depois do 25 de abril')");

        jdbcTemplate.execute("INSERT INTO livro_genero (livro_id, genero_id) VALUES (1, 3)");
        jdbcTemplate.execute("INSERT INTO livro_genero (livro_id, genero_id) VALUES (2, 2)");

        jdbcTemplate.execute("INSERT INTO livro_autor (livro_id, autor_id) VALUES (1, 5)");
        jdbcTemplate.execute("INSERT INTO livro_autor (livro_id, autor_id) VALUES (2, 3)");
    }
}
