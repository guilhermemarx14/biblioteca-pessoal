package com.poxete.biblioteca_pessoal.repository;

import com.poxete.biblioteca_pessoal.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GeneroRepository extends JpaRepository<Genero, String> {
    @Query("SELECT g FROM Genero g  WHERE upper(g.nome) like ?1 ORDER BY g.nome")
    List<Genero> encontrarPorIdLike(String nome);

}
