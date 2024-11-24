package com.poxete.biblioteca_pessoal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ComponentScan(basePackages = "com.poxete.biblioteca_pessoal")
public class AppConfig {

    @Bean
    public Connection connection(Properties properties) throws SQLException {
        return DriverManager.getConnection(properties.getDatasourceUrl(), properties.getDatasourceUsername(), properties.getDatasourcePassword());
    }
}
