package com.poxete.biblioteca_pessoal.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {
    public static String prepararLikeParaBuscaGenerica(String query) {
        if (query == null || query.replaceAll("\\s+", "").isEmpty())
            return "";
        return "%" + query.toUpperCase().trim().replaceAll("\\s+", "%") + "%";
    }

    public static String formatarListaComE(List<?> lista) {
        if (lista.isEmpty()) {
            return "";
        }

        if (lista.size() == 1) {
            return lista.get(0).toString();
        }

        List<String> listaString = lista.stream().map(Object::toString).toList();

        return String.join(", ", listaString.subList(0, listaString.size() - 1)) + " e " + listaString.get(listaString.size() - 1);
    }
}
