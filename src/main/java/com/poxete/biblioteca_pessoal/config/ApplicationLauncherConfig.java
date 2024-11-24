package com.poxete.biblioteca_pessoal.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApplicationLauncherConfig {
    public static void openBrowser() {
        String os = System.getProperty("os.name").toLowerCase();

        try {
            String url = "http://localhost:8080"; // A URL que você deseja abrir

            // Verifica se é um sistema Windows
            if (os.contains("win")) {
                // Comando para abrir o navegador no Windows
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else {
                log.error("Sistema operacional não suportado para abrir o navegador automaticamente. Abra manualmente.");
            }
        } catch (IOException e) {
            log.error(e);
        }
    }
}
