package com.poxete.biblioteca_pessoal.usecase.salvar;

import com.poxete.biblioteca_pessoal.ConfiguraBaseEmMemoria;
import com.poxete.biblioteca_pessoal.service.dto.LivroCompletoDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.google.common.truth.Truth.assertThat;

@SpringBootTest(properties = "spring.profiles.active=test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SalvarLivroUseCaseTest {
    @Autowired
    ConfiguraBaseEmMemoria configuraBaseEmMemoria;

    @Autowired
    SalvarLivroUseCase salvarLivroUseCase;

    @BeforeAll
    public void setup() {
        configuraBaseEmMemoria.configurarBancoDeDados();
    }

    @Test
    void deveSalvarLivroNovo() {
        var livroSalvo = salvarLivroUseCase.salvarLivro(mockLivroCompletoDTOMultiplosAutoresEgeneros());

        assertThat(livroSalvo.getId()).isEqualTo(3);

    }

    private LivroCompletoDTO mockLivroCompletoDTOMultiplosAutoresEgeneros() {
        return LivroCompletoDTO.builder()
                .titulo("titulo")
                .lido(true)
                .anoPublicacao(2020)
                .generos("genero1;genero2")
                .autores("Poxete1;poxete2")
                .editora("editora")
                .localizacao("localizacao")
                .quantidade(1)
                .classificacao(1)
                .dataLeitura(null)
                .comentario("comentario")
                .sinopse("sinopse")
                .favorito(true)
                .build();
    }
}
