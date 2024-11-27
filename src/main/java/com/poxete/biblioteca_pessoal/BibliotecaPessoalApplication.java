package com.poxete.biblioteca_pessoal;

import com.poxete.biblioteca_pessoal.config.ApplicationLauncherConfig;
import com.poxete.biblioteca_pessoal.utils.IgnorarNoCoverage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * inicia a aplicação
 */
@SpringBootApplication
@EnableFeignClients
@IgnorarNoCoverage
@EnableJpaRepositories(basePackages = "com.poxete.biblioteca_pessoal.repository")
public class BibliotecaPessoalApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(BibliotecaPessoalApplication.class).run(args);

        ApplicationLauncherConfig.openBrowser();
    }

}
