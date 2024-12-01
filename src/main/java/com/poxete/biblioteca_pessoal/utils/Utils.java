package com.poxete.biblioteca_pessoal.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {

    /**
     * Realiza uma busca genérica por livros com base em uma consulta.
     *
     * @param query consulta a ser utilizada para buscar livros
     * @return lista de livros que correspondem à consulta
     */
    public static String prepararLikeParaBuscaGenerica(String query) {
        if (query == null || query.replaceAll("\\s+", "").isEmpty())
            return "";
        return "%" + query.toUpperCase().trim().replaceAll("\\s+", "%") + "%";
    }

    /**
     * Formata uma lista de objetos em uma string, separando os elementos com vírgulas e adicionando "e" antes do último elemento.
     *
     * @param lista lista de objetos a ser formatada
     * @return string formatada com os elementos da lista
     */
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

    /**
     * Capitaliza as palavras de um texto, exceto as palavras "de", "e", "do", "dos", "da", "das" e "que".
     *
     * @param texto texto a ser capitalizado
     * @return texto com as palavras capitalizadas
     */
    public static String capitalizarPalavras(String texto) {
        if (texto == null || texto.trim().isEmpty())
            return "";
        StringBuilder resultado = new StringBuilder();
        String[] tokens = texto.replaceAll("\\s+", " ").trim().split(" ");

        for (String token : tokens) {
            if (token.contains("-")) {
                String[] subTokens = token.split("-");
                for (int i = 0; i < subTokens.length; i++) {
                    subTokens[i] = subTokens[i].substring(0, 1).toUpperCase() + subTokens[i].substring(1).toLowerCase();
                }
                token = String.join("-", subTokens);
            } else if (!token.equalsIgnoreCase("de") && !token.equalsIgnoreCase("e") && !token.equalsIgnoreCase("do") &&
                    !token.equalsIgnoreCase("dos") && !token.equalsIgnoreCase("da") && !token.equalsIgnoreCase("das") &&
                    !token.equalsIgnoreCase("que")) {
                token = token.substring(0, 1).toUpperCase() + token.substring(1).toLowerCase();
            } else {
                token = token.toLowerCase();
            }
            resultado.append(token).append(" ");
        }

        return resultado.toString().trim();
    }

    /**
     * Retorna uma string com a stack trace da exce o.
     *
     * @param e Exce o a ser serializada
     * @return String com a stack trace da exce o
     */
    @IgnorarNoCoverage
    public static String serializarExcecao(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }

    public static List<String> obterItensDeListaAPartirDeString(String autores) {
        return Arrays.stream(autores.split(";")).toList();
    }
}
