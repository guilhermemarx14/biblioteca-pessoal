package com.poxete.biblioteca_pessoal.repository;

import com.poxete.biblioteca_pessoal.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
