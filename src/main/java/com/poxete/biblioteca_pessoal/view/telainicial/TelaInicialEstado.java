package com.poxete.biblioteca_pessoal.view.telainicial;

import com.poxete.biblioteca_pessoal.view.componentes.IconeComLabel;
import com.poxete.biblioteca_pessoal.view.interfaces.Estado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TelaInicialEstado implements Estado {
    List<IconeComLabel> iconesComLabel;


}
