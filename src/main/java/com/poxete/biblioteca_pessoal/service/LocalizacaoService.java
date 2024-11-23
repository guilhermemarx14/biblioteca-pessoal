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

    public Localizacao salvar(Localizacao localizacao) {
        return localizacaoRepository.save(localizacao);
    }

    public Localizacao buscarPorId(Integer id) {
        return localizacaoRepository.findById(id).orElse(null);
    }

    public List<Localizacao> buscarLocalizacaoPorDescricao(String descricao) {
        return localizacaoRepository.findAllByDescricaoLike(descricao);
    }
}
