package com.poxete.biblioteca_pessoal.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {
    public static String prepararLikeParaBuscaGenerica(String query) {
        return "%" + query.toUpperCase().trim().replaceAll("\\s+", "%") + "%";
    }
}
