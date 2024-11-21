package com.poxete.biblioteca_pessoal.repository;

import com.poxete.biblioteca_pessoal.model.Editora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EditoraRepository extends JpaRepository<Editora, Integer> {

    Optional<Editora> findByNome(String nome);
}
