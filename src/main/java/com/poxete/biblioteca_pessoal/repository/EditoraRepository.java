package com.poxete.biblioteca_pessoal.repository;

import com.poxete.biblioteca_pessoal.model.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EditoraRepository extends JpaRepository<Editora, Integer> {

    @Query("Select e from Editora e where upper(e.nome) like ?1")
    List<Editora> buscarTodosPorNome(String nome);


    @Query("Select e from Editora e where upper(e.nome) = ?1")
    Optional<Editora> buscarPorNome(String nome);
}
