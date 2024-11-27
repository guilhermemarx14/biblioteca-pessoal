package com.poxete.biblioteca_pessoal.config;

import com.poxete.biblioteca_pessoal.utils.IgnorarNoCoverage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
@IgnorarNoCoverage
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApplicationLauncherConfig {
    /**
     * Abre o navegador com a URL do sistema. Se o sistema operacional
     * for Windows, abre a URL no navegador padr o. Caso contr rio,
     * exibe um erro e solicita que o usu rio abra manualmente.
     */
    public static void openBrowser() {
        String url = "http://localhost:8080";

        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
        } catch (IOException e) {
            log.error("Erro ao tentar abrir o navegador: " + e.getMessage(), e);
        }
    }
}
