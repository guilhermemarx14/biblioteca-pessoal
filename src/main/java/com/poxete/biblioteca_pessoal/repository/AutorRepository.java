package com.poxete.biblioteca_pessoal.repository;

import com.poxete.biblioteca_pessoal.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, String> {

    @Query("SELECT a FROM Autor a WHERE upper(a.nome) = ?1")
    Optional<Autor> buscarPorNomeCompleto(String nomeCompleto);

    @Query("SELECT a FROM Autor a WHERE upper(a.nome) LIKE ?1")
    List<Autor> buscarPorParteNome(String parteNome);

    List<Autor> findAllByFavorito(Boolean favorito);
}
