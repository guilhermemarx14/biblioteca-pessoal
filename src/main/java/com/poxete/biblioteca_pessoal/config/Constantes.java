package com.poxete.biblioteca_pessoal.config;

import com.poxete.biblioteca_pessoal.utils.IgnorarNoCoverage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@IgnorarNoCoverage
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constantes {
    public static final String MENSAGEM_EXCEPTION_AUTOR_NAO_ENCONTRADO = "Autor %s não encontrado";
    public static final String MENSAGEM_EXCEPTION_SERIALIZACAO = "Você deve fornecer pelo menos um parâmetro de classe para a serialização.";
}
