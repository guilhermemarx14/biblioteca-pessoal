package com.poxete.biblioteca_pessoal.view.telainicial;

import com.poxete.biblioteca_pessoal.view.interfaces.Estado;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TelaInicialEstado implements Estado {
    EventHandler<ActionEvent> listarLivrosCadastradosHandler;
    EventHandler<ActionEvent> cadastrarNovoLivroHandler;
}
