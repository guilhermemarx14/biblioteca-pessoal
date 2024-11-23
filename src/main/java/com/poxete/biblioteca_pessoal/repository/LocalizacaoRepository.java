package com.poxete.biblioteca_pessoal.repository;

import com.poxete.biblioteca_pessoal.model.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Integer> {
    @Query("Select l from Localizacao l where upper(l.descricao) like ?1")
    List<Localizacao> findAllByDescricaoLike(String descricao);
}
