package com.poxete.biblioteca_pessoal.service;

import com.poxete.biblioteca_pessoal.model.Localizacao;
import com.poxete.biblioteca_pessoal.repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalizacaoService {
    @Autowired
    LocalizacaoRepository localizacaoRepository;

    public List<Localizacao> buscarLocalizacaoPorParteDescricao(String descricao) {
        return localizacaoRepository.encontrarPorPerteDescricao(descricao);
    }

    public Localizacao salvar(Localizacao localizacao) {
        if (localizacao == null || localizacao.getDescricao() == null || localizacao.getDescricao().isEmpty()) {
            return null;
        }
        var localizacaoExistente = localizacaoRepository.findById(localizacao.getDescricao());
        return localizacaoExistente.orElseGet(() -> localizacaoRepository.save(localizacao));
    }
}
