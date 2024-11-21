package com.poxete.biblioteca_pessoal.view.componentes;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public record IconeComLabel(String label, String icone, Integer espacamento, EventHandler<MouseEvent> handler) {
}
