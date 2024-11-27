package com.poxete.biblioteca_pessoal.config;

import com.poxete.biblioteca_pessoal.utils.IgnorarNoCoverage;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Classe que lê e fornece as propriedades de configuração da aplicação.
 */
@Getter
@Component
@IgnorarNoCoverage
public class Properties {
    /**
     * URL do banco de dados.
     */
    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    /**
     * Nome de usuário do banco de dados.
     */
    @Value("${spring.datasource.username}")
    private String datasourceUsername;

    /**
     * Senha do banco de dados.
     */
    @Value("${spring.datasource.password}")
    private String datasourcePassword;

    /**
     * URL do launcher da aplicação.
     */
    @Value("${spring.launcher.url}")
    private String launcherUrl;
}
