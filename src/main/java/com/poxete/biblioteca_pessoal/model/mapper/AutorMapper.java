package com.poxete.biblioteca_pessoal.model.mapper;

import com.poxete.biblioteca_pessoal.model.Autor;
import com.poxete.biblioteca_pessoal.service.dto.AutorDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;

import static com.poxete.biblioteca_pessoal.utils.Utils.formatarListaComE;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AutorMapper {
    public static Autor transformarAutorDTOemAutor(AutorDTO autorDTO) {
        var outrosNomes = new ArrayList<>(Arrays.stream(autorDTO.getOutrosNomes().split("\n")).toList());

        return new Autor(autorDTO.getNome(), outrosNomes);
    }

    public static AutorDTO transformarAutorEmAutorDTO(Autor autor) {
        return new AutorDTO(autor.getNome(), formatarListaComE(autor.getOutrosNomes()));
    }
}
