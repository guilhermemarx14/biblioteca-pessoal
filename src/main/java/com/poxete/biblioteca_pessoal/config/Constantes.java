package com.poxete.biblioteca_pessoal.config;

import com.poxete.biblioteca_pessoal.utils.IgnorarNoCoverage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@IgnorarNoCoverage
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constantes {
    public static final String MENSAGEM_EXCEPTION_AUTOR_NAO_ENCONTRADO = "Autor %s não encontrado";
    public static final String MENSAGEM_EXCEPTION_LIVRO_NAO_ENCONTRADO = "Livro com id %d não encontrado";
    public static final String MENSAGEM_EXCEPTION_SERIALIZACAO = "Você deve fornecer pelo menos um parâmetro de classe para a serialização.";


    //promt
    public static final String PROMT_RECOMENDACAO = """
            Dado que meus livros favoritos são %s e os livros que eu já li são %s, me recomende 3 livros que eu ainda não tenha lido.
            Considere também que meus autores favoritos são %s. não me recomende dos livros que eu citei.
            Enumere as indicações.
            """;

}
