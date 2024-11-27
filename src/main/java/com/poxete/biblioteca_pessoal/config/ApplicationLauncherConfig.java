package com.poxete.biblioteca_pessoal.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApplicationLauncherConfig {
    /**
     * Abre o navegador com a URL do sistema. Se o sistema operacional
     * for Windows, abre a URL no navegador padr o. Caso contr rio,
     * exibe um erro e solicita que o usu rio abra manualmente.
     */
    public static void openBrowser() {
        String os = System.getProperty("os.name").toLowerCase();

        try {
            String url = "http://localhost:8080"; // A URL que você deseja abrir

            // Verifica se é um sistema Windows
            if (os.contains("win")) {
                // Comando para abrir o navegador no Windows
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);//todo: exec está depreciado
            } else {
                log.error("Sistema operacional não suportado para abrir o navegador automaticamente. Abra manualmente.");
            }
        } catch (IOException e) {
            log.error(e);
        }
    }
}
