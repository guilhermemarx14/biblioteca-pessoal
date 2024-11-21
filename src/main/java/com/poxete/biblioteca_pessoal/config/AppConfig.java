package com.poxete.biblioteca_pessoal.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.poxete.biblioteca_pessoal")
public class AppConfig {
    @Bean
    public SpringFXMLLoaderConfig springFXMLLoaderConfig(ApplicationContext context) {
        return new SpringFXMLLoaderConfig(context);
    }
}
