package com.poxete.biblioteca_pessoal.service;

import com.poxete.biblioteca_pessoal.service.client.WikipediaFeignClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WikipediaService {
    @Autowired
    private WikipediaFeignClient wikipediaFeignClient;
    private static final String ACTION_QUERY = "query";
    private static final String LIST_SEARCH = "search";

    public String obterDadosWikipedia(String nome) {
        String reposta = wikipediaFeignClient.search(ACTION_QUERY, LIST_SEARCH, nome, "json", "*");
        Integer idPagina = extractPageIdFromResponse(reposta);

        String biografiaResponse = wikipediaFeignClient.getPageExtract(ACTION_QUERY, "extracts", true, idPagina, "json", "*");

        return extrairDadosDoResponse(biografiaResponse);
    }

    private Integer extractPageIdFromResponse(String response) {
        JSONObject jsonResponse = new JSONObject(response);
        JSONArray searchResults = jsonResponse.getJSONObject(ACTION_QUERY).getJSONArray(LIST_SEARCH);
        JSONObject firstResult = searchResults.getJSONObject(0);
        return firstResult.getInt("pageid");
    }

    private String extrairDadosDoResponse(String response) {
        JSONObject jsonResponse = new JSONObject(response);
        JSONObject page = jsonResponse.getJSONObject(ACTION_QUERY).getJSONObject("pages");
        JSONObject pageContent = page.getJSONObject(page.keys().next());
        return pageContent.getString("extract");
    }

}
