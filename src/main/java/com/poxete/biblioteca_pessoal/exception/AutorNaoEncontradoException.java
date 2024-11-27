package com.poxete.biblioteca_pessoal.exception;

import com.poxete.biblioteca_pessoal.utils.IgnorarNoCoverage;

@IgnorarNoCoverage
public class AutorNaoEncontradoException extends RuntimeException {
    public AutorNaoEncontradoException(String texto) {
        super(texto);
    }
}
