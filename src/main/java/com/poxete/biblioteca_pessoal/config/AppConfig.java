package com.poxete.biblioteca_pessoal.config;

import com.poxete.biblioteca_pessoal.utils.IgnorarNoCoverage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe de configuração da aplicação.
 *
 * @author Poxete
 * @since 1.0
 */
@Configuration

@IgnorarNoCoverage
@ComponentScan(basePackages = "com.poxete.biblioteca_pessoal")
public class AppConfig {

    /**
     * Cria uma conexão com o banco de dados.
     *
     * @param properties propriedades de configuração do banco de dados
     * @return conexão com o banco de dados
     * @throws SQLException se ocorrer um erro ao criar a conexão
     */
    @Bean
    public Connection connection(Properties properties) throws SQLException {
        return DriverManager.getConnection(properties.getDatasourceUrl(), properties.getDatasourceUsername(), properties.getDatasourcePassword());
    }


}
