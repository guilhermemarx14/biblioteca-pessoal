package com.poxete.biblioteca_pessoal.repository;

import com.poxete.biblioteca_pessoal.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
    @Query("Select l from Livro l where upper(l.titulo) like ?1")
    List<Livro> buscarPorTituloLike(String titulo);


    @Query("SELECT l FROM Livro l JOIN l.autores a WHERE a IN :autores")
    List<Livro> buscarTodosPorAutor(@Param("autores") List<Autor> autores);

    @Query("SELECT l FROM Livro l JOIN l.generos g WHERE g IN :generos")
    List<Livro> buscarTodosPorGenero(@Param("generos") List<Genero> generos);

    List<Livro> findAllByEditoraIn(List<Editora> editoras);

    List<Livro> findAllByLocalizacaoIn(List<Localizacao> localizacoes);
}
