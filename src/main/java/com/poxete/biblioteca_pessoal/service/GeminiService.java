package com.poxete.biblioteca_pessoal.service;

import com.poxete.biblioteca_pessoal.service.client.GeminiFeignClient;
import com.poxete.biblioteca_pessoal.service.client.dto.CorpoDaRequisicaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GeminiService {
    @Autowired
    GeminiFeignClient geminiFeignClient;

    @Value("${gemini.api.key}")
    String key;

    public String obterRecomendacao(String promt) {
        // Lógica para processar o corpo da requisição
        var body = new CorpoDaRequisicaoDTO(promt);

        return geminiFeignClient.search(key, body).obterTexto();
    }
}
