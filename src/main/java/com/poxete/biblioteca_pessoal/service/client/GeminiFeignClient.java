package com.poxete.biblioteca_pessoal.service.client;

import com.poxete.biblioteca_pessoal.service.client.dto.CorpoDaRequisicaoDTO;
import com.poxete.biblioteca_pessoal.service.client.dto.RespostaDaRequisicaoDTO;
import feign.FeignException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "gemini-client", url = "${gemini.api.url}")
public interface GeminiFeignClient {
    @PostMapping
    RespostaDaRequisicaoDTO search(@RequestParam("key") String key, @RequestBody CorpoDaRequisicaoDTO corpoDaRequisicaoDTO) throws FeignException;
}
