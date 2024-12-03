package com.poxete.biblioteca_pessoal.repository;

import com.poxete.biblioteca_pessoal.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GeneroRepository extends JpaRepository<Genero, Integer> {
    @Query("SELECT g FROM Genero g  WHERE upper(g.nome) = ?1")
    Optional<Genero> encontrarPorNome(String nome);

    @Query("SELECT g FROM Genero g  WHERE upper(g.nome) LIKE ?1")
    List<Genero> encontrarPorParteNome(String parteNome);

}
