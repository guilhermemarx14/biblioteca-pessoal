package com.poxete.biblioteca_pessoal.service.dto;

import com.poxete.biblioteca_pessoal.utils.IgnorarNoCoverage;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IgnorarNoCoverage
public class AutorDTO {
    String nome;
    String outrosNomes;
    Boolean favorito;
}
