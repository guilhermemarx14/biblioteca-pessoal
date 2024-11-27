package com.poxete.biblioteca_pessoal.exception;

import com.poxete.biblioteca_pessoal.utils.IgnorarNoCoverage;
import com.poxete.biblioteca_pessoal.utils.Serializador;
import com.poxete.biblioteca_pessoal.utils.Utils;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@IgnorarNoCoverage
@ControllerAdvice
@Log4j2
public class TratamentoExcecao {

    @ExceptionHandler(AutorNaoEncontradoException.class)
    protected ResponseEntity<Object> httpException(AutorNaoEncontradoException ex) {
        return TratamentoExcecao.handleGeneralException(ex, HttpStatus.NOT_FOUND, ex.getMessage());
    }

    public static ResponseEntity<Object> handleGeneralException(Exception exception, HttpStatus status, String message) {
        try {
            log.error(Utils.serializarExcecao(exception));
            ErroObjeto erroObjeto = new ErroObjeto(status.value(), message);
            String objetoSerializado = Serializador.serialize(erroObjeto);
            log.error(exception.getMessage(), exception);
            return new ResponseEntity<>(objetoSerializado, status);
        } catch (Exception ex) {
            return new ResponseEntity<>("Erro ao serializar o objeto de erro", status);
        }
    }

    @Getter
    @Setter
    @IgnorarNoCoverage
    public static class ErroObjeto {
        private Integer statusCode;
        private String message;

        public ErroObjeto(Integer statusCode, String message) {
            this.statusCode = statusCode;
            this.message = message;
        }
    }
}
