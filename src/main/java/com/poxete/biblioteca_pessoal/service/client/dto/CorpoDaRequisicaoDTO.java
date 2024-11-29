package com.poxete.biblioteca_pessoal.service.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CorpoDaRequisicaoDTO {

    private List<Content> contents;

    public CorpoDaRequisicaoDTO(String promt) {
        this.contents = List.of(new Content(List.of(new Part(promt))));
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Content {
        private List<Part> parts;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Part {
        private String text;
    }
}
