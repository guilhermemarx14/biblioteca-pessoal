package com.poxete.biblioteca_pessoal.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
            return lista.getFirst().toString();
        }

        List<String> listaString = lista.stream().map(Object::toString).toList();

        return String.join(", ", listaString.subList(0, listaString.size() - 1)) + " e " + listaString.getLast();
    }


    public static String capitalizarPalavras(String textoOriginal) {
        if (textoOriginal == null || textoOriginal.trim().isEmpty())
            return "";


        String texto = textoOriginal.replaceAll("\\s+", " ").trim();

        String[] palavras = texto.split(" ");

        StringBuilder resultado = new StringBuilder();

        String[] excecoes = {"de", "e", "do", "dos", "da", "das", "que"};

        for (String palavra : palavras) {
            if (isExcecao(palavra, excecoes)) {
                resultado.append(palavra.toLowerCase()).append(" ");
            } else {
                resultado.append(palavra.substring(0, 1).toUpperCase()).append(palavra.substring(1).toLowerCase()).append(" ");
            }
        }

        // Retorna o texto capitalizado, removendo o último espaço extra
        return resultado.toString().trim();
    }

    // Verifica se a palavra está na lista de exceções
    private static boolean isExcecao(String palavra, String[] excecoes) {
        for (String excecao : excecoes) {
            if (palavra.equalsIgnoreCase(excecao)) {
                return true;
            }
        }
        return false;
    }


    @IgnorarNoCoverage
    public static String serializarExcecao(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }

    public static List<String> obterItensDeListaAPartirDeString(String autores) {
        if (autores == null || autores.isEmpty())
            return List.of();
        return Arrays.stream(autores.split(";")).toList();
    }

    public static String obterStringAPartirDeLista(List<String> autores) {
        if (autores == null || autores.isEmpty())
            return "";
        return autores.stream().collect(Collectors.joining(";"));
    }
}
