package com.poxete.biblioteca_pessoal.model;

import com.poxete.biblioteca_pessoal.model.mapper.LivroMapper;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static com.poxete.biblioteca_pessoal.utils.Utils.capitalizarPalavras;
import static com.poxete.biblioteca_pessoal.utils.Utils.formatarListaComE;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    public Livro(String titulo,
                 Integer anoPublicacao,
                 List<Genero> generos,
                 List<Autor> autores,
                 Editora editora,
                 Localizacao localizacao,
                 Integer quantidade) {
        this.titulo = titulo;
        this.lido = false;
        this.anoPublicacao = anoPublicacao;
        this.generos = generos;
        this.autores = autores;
        this.editora = editora;
        this.localizacao = localizacao;
        this.quantidade = quantidade;
        this.classificacao = 0;
        this.dataLeitura = new Date(LocalDate.MIN.toEpochDay());
        this.comentario = "";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull
    String titulo;

    @NotNull
    Boolean lido;

    @NotNull
    Integer anoPublicacao;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "livro_genero", joinColumns = @JoinColumn(name = "livro_id"), inverseJoinColumns = @JoinColumn(name = "genero_id"))
    List<Genero> generos;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "livro_autor", joinColumns = @JoinColumn(name = "livro_id"), inverseJoinColumns = @JoinColumn(name = "autor_id"))
    List<Autor> autores;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "editora_id")
    Editora editora;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "localizacao_id")
    Localizacao localizacao;

    @NotNull
    Integer quantidade;

    Integer classificacao;

    Date dataLeitura;

    String comentario;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString() {
        return (LivroMapper.transformarLivroEmLivroResumoDTO(this)).toString();
    }

    public String obterAutoresComoString() {
        return capitalizarPalavras(formatarListaComE(autores.stream().map(Autor::getNome).toList()));
    }

    public String obterGenerosComoString() {
        return capitalizarPalavras(formatarListaComE(generos.stream().map(Genero::getNome).toList()));
    }
}
