package com.poxete.biblioteca_pessoal.config;

import com.poxete.biblioteca_pessoal.utils.IgnorarNoCoverage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@IgnorarNoCoverage
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constantes {
    // mensagens de exceptions
    public static final String MENSAGEM_EXCEPTION_LIVRO_NAO_ENCONTRADO = "Livro com id %d não encontrado";
    public static final String MENSAGEM_EXCEPTION_SERIALIZACAO = "Você deve fornecer pelo menos um parâmetro de classe para a serialização.";


    //promt
    public static final String PROMT_RECOMENDACAO = """
            Dado que meus livros favoritos são %s e os livros que eu já li são %s, me recomende 3 livros que eu ainda não tenha lido.
            Considere também que meus autores favoritos são %s. não me recomende dos livros que eu citei.
            Enumere as indicações.
            """;

    public static final String PROMT_SINOPSE = """
            Me traga a sinopse do livro %s do autor %s
            """;


    public static final String NAO_FORAM_ENCONTRADOS_DADOS_AUTOR = "Não foram encontrados dados para o autor.";

    public static final String NAO_FOI_POSSIVEL_OBTER_RECOMENDACOES = "Não foi possível obter recomendações.";
}
