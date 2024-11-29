package com.poxete.biblioteca_pessoal.service.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RespostaDaRequisicaoDTO {
    private List<Candidate> candidates;

    public String obterTexto() {
        return candidates.getFirst().content.parts.getFirst().text;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Candidate {
        private Content content;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Content {
        private List<Part> parts;

    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Part {
        private String text;

    }
}
