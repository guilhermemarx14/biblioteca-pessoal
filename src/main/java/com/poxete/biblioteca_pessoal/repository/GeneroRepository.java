package com.poxete.biblioteca_pessoal.repository;

import com.poxete.biblioteca_pessoal.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeneroRepository extends JpaRepository<Genero, Integer> {
    Optional<Genero> findByNome(String nome);
}
