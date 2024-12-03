package com.poxete.biblioteca_pessoal.repository;

import com.poxete.biblioteca_pessoal.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Integer> {

    @Query("SELECT a FROM Autor a WHERE upper(a.nome) = ?1")
    Optional<Autor> buscarPorNomeCompleto(String nomeCompleto);

    @Query("SELECT a FROM Autor a WHERE upper(a.nome) LIKE :parteNome")
    List<Autor> buscarPorParteNome(@Param("parteNome") String parteNome);

    List<Autor> findAllByFavorito(Boolean favorito);
}
