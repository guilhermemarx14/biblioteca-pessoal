package com.poxete.biblioteca_pessoal.usecase.obter;

import com.poxete.biblioteca_pessoal.model.Autor;
import com.poxete.biblioteca_pessoal.model.mapper.LivroMapper;
import com.poxete.biblioteca_pessoal.service.AutorService;
import com.poxete.biblioteca_pessoal.service.GeminiService;
import com.poxete.biblioteca_pessoal.service.LivroService;
import com.poxete.biblioteca_pessoal.utils.Utils;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.poxete.biblioteca_pessoal.config.Constantes.NAO_FOI_POSSIVEL_OBTER_RECOMENDACOES;
import static com.poxete.biblioteca_pessoal.config.Constantes.PROMT_RECOMENDACAO;

@Component
public class ObterRecomendacoesUseCase {
    @Autowired
    LivroService livroService;

    @Autowired
    GeminiService geminiService;

    @Autowired
    AutorService autorService;

    public String obterRecomendacoes() {
        var favoritos = livroService.buscarTodosPorFavorito().stream().map(LivroMapper::transformarLivroEmLivroResumoDTO).toList();
        var lidosNaoFavoritados = livroService.buscarTodosPorLidoENaoFavorito().stream().map(LivroMapper::transformarLivroEmLivroResumoDTO).toList();
        var autoresFavoritos = autorService.buscarPorFavorito().stream().map(Autor::getNome).toList();
        var promt = PROMT_RECOMENDACAO.formatted(
                Utils.formatarListaComE(favoritos),
                Utils.formatarListaComE(lidosNaoFavoritados),
                Utils.formatarListaComE(autoresFavoritos)
        );
        var retorno = "";
        try {
            retorno = geminiService.realizarConsulta(promt).replaceAll("1.", "<br>1.").replaceAll("2.", "<br>2.").replaceAll("3.", "<br>3.");
        } catch (FeignException e) {
            retorno = NAO_FOI_POSSIVEL_OBTER_RECOMENDACOES;
        }


        return retorno;
    }
}
