package com.poxete.biblioteca_pessoal.exception;

import com.poxete.biblioteca_pessoal.utils.IgnorarNoCoverage;

@IgnorarNoCoverage
public class LivroNaoEncontradoException extends RuntimeException {
    public LivroNaoEncontradoException(String texto) {
        super(texto);
    }
}
