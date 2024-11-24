CREATE TABLE Autor
(
    nome VARCHAR(255) NOT NULL, -- Chave primária
    PRIMARY KEY (nome)
);

CREATE TABLE autor_outros_nomes
(
    autor_id     VARCHAR(255) NOT NULL,   -- Chave estrangeira para Autor.nome
    outros_nomes VARCHAR(255) NOT NULL,   -- Elementos da coleção
    PRIMARY KEY (autor_id, outros_nomes), -- Combinação única de autor e nome
    FOREIGN KEY (autor_id) REFERENCES Autor (nome) ON DELETE CASCADE
);
