package com.poxete.biblioteca_pessoal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.poxete.biblioteca_pessoal.repository")
public class BibliotecaPessoalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaPessoalApplication.class, args);
	}

}
