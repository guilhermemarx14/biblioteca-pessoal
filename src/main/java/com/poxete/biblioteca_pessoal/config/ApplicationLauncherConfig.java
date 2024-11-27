package com.poxete.biblioteca_pessoal.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Log4j2
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
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {

                Desktop.getDesktop().browse(new URI(url));
            } else {
                log.error("Ação BROWSE não suportada neste sistema. Abra manualmente: " + url);
            }
        } catch (IOException | URISyntaxException e) {
            log.error("Erro ao tentar abrir o navegador: " + e.getMessage(), e);
        }
    }
}
