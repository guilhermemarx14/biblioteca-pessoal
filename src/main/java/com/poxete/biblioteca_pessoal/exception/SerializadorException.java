package com.poxete.biblioteca_pessoal.exception;

import com.poxete.biblioteca_pessoal.utils.IgnorarNoCoverage;

@IgnorarNoCoverage
public class SerializadorException extends RuntimeException {
    public SerializadorException(String message) {
        super(message);
    }
}
