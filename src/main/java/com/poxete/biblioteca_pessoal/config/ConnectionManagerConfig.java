package com.poxete.biblioteca_pessoal.config;

import jakarta.annotation.PreDestroy;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Log4j2
@Component
public class ConnectionManagerConfig {
    @Autowired
    ApplicationContext applicationContext;

    @PreDestroy
    public void closeConnection() {
        var connection = applicationContext.getBean(Connection.class);
        try {
            connection.close();
        } catch (SQLException e) {
            log.error("Erro ao fechar a conexão com o banco de dados.", e);
        }
    }
}
