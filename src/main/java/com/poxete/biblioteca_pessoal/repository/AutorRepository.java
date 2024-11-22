package com.poxete.biblioteca_pessoal.repository;

import com.poxete.biblioteca_pessoal.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
