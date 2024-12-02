package com.poxete.biblioteca_pessoal.repository;

import com.poxete.biblioteca_pessoal.model.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Integer> {
    @Query("Select l from Localizacao l where upper(l.descricao) like ?1")
    List<Localizacao> encontrarPorPerteDescricao(String descricao);

    @Query("Select l from Localizacao l where upper(l.descricao) = ?1")
    Optional<Localizacao> obterPorDescricao(String descricao);
}
