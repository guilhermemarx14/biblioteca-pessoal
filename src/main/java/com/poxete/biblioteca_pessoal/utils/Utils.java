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

    public static String capitalizarPalavras(String texto) {
        if (texto == null)
            return "";
        StringBuilder resultado = new StringBuilder();
        String[] tokens = texto.replaceAll("\\s+", " ").trim().split(" "); // Substitui múltiplos espaços por um único espaço

        for (String token : tokens) {
            if (!token.equalsIgnoreCase("de") && !token.equalsIgnoreCase("e") && !token.equalsIgnoreCase("do") && !token.equalsIgnoreCase("dos") &&
                    !token.equalsIgnoreCase("da") && !token.equalsIgnoreCase("das") && !token.equalsIgnoreCase("que")) {
                token = token.substring(0, 1).toUpperCase() + token.substring(1).toLowerCase();
            } else {
                token = token.toLowerCase();
            }
            resultado.append(token).append(" "); // Adiciona um espaço após cada token
        }

        return resultado.toString().trim();
    }
}
