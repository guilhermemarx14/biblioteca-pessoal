package com.poxete.biblioteca_pessoal.usecase.salvar;

import com.poxete.biblioteca_pessoal.model.Localizacao;
import com.poxete.biblioteca_pessoal.service.LocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalvarLocalizacaoUseCase {
    @Autowired
    LocalizacaoService localizacaoService;

    public Localizacao salvar(Localizacao localizacao) {
        return localizacaoService.salvar(localizacao);
    }
}
