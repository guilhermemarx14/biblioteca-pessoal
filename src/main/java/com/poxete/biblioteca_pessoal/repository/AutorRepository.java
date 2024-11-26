package com.poxete.biblioteca_pessoal.repository;

import com.poxete.biblioteca_pessoal.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, String> {

    @Query("SELECT a FROM Autor a LEFT JOIN a.outrosNomes nome WHERE upper(a.nome) LIKE ?1 OR upper(nome) LIKE ?1")
    Optional<Autor> buscarPorNomeCompleto(String parteNome);

    @Query("SELECT a FROM Autor a LEFT JOIN a.outrosNomes nome WHERE upper(a.nome) LIKE ?1 OR upper(nome) LIKE ?1")
    List<Autor> buscarPorParteNome(String parteNome);

}
