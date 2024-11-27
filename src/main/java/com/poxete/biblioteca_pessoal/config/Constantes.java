package com.poxete.biblioteca_pessoal.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constantes {
    public static final String MENSAGEM_EXCEPTION_AUTOR_NAO_ENCONTRADO = "Autor %s não encontrado";
    public static final String MENSAGEM_EXCEPTION_SERIALIZACAO = "Você deve fornecer pelo menos um parâmetro de classe para a serialização.";
}
