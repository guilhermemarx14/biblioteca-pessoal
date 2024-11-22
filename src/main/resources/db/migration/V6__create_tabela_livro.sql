-- Criação da tabela Livro
CREATE TABLE IF NOT EXISTS livro
(
    id             INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    titulo         VARCHAR(255) NOT NULL,
    ano_publicacao INT          NOT NULL,
    editora_id     INT          NOT NULL,
    localizacao_id INT          NOT NULL,
    quantidade     INT          NOT NULL,
    lido           BOOLEAN      NOT NULL,
    FOREIGN KEY (editora_id) REFERENCES editora (id),
    FOREIGN KEY (localizacao_id) REFERENCES localizacao (id)
);

-- Tabela de relacionamento entre Livro e Genero (Many-to-Many)
CREATE TABLE IF NOT EXISTS livro_genero
(
    livro_id  INT NOT NULL,
    genero_id INT NOT NULL,
    PRIMARY KEY (livro_id, genero_id),
    FOREIGN KEY (livro_id) REFERENCES livro (id),
    FOREIGN KEY (genero_id) REFERENCES genero (id)
);

-- Tabela de relacionamento entre Livro e Autor (Many-to-Many)
CREATE TABLE IF NOT EXISTS livro_autor
(
    livro_id INT NOT NULL,
    autor_id INT NOT NULL,
    PRIMARY KEY (livro_id, autor_id),
    FOREIGN KEY (livro_id) REFERENCES livro (id),
    FOREIGN KEY (autor_id) REFERENCES autor (id)
);