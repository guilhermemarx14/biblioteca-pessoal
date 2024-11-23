package com.poxete.biblioteca_pessoal.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {
    public static <T> boolean compararListasDesordenadas(List<T> lista1,
                                                         List<T> lista2) {
        if (lista1 == null || lista2 == null) {
            return lista1 == lista2;
        }

        if (lista1.size() != lista2.size()) {
            return false;
        }

        Set<T> set1 = new HashSet<>(lista1);
        Set<T> set2 = new HashSet<>(lista2);

        return set1.equals(set2);
    }

    public static String prepararLikeParaBuscaGenerica(String query) {
        return "%" + query.toUpperCase().trim().replaceAll("\\s+", "%") + "%";
    }
}
