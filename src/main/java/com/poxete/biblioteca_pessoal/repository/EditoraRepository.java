package com.poxete.biblioteca_pessoal.repository;

import com.poxete.biblioteca_pessoal.model.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EditoraRepository extends JpaRepository<Editora, String> {

    @Query("Select e from Editora e where upper(e.nome) like ?1")
    List<Editora> buscarTodosPorNome(String nome);

}
