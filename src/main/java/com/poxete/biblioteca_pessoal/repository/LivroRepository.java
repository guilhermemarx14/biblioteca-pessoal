package com.poxete.biblioteca_pessoal.repository;

import com.poxete.biblioteca_pessoal.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
    @Query("Select l from Livro l where upper(l.titulo) like ?1")
    List<Livro> findAllByTituloLike(String titulo);
}
