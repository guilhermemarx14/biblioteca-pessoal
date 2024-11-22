-- Criação da tabela principal 'autor'
CREATE TABLE IF NOT EXISTS autor
(
    id   INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);
-- Criação da tabela associada 'autor_outros_nomes' para armazenar os outros nomes
CREATE TABLE IF NOT EXISTS autor_outros_nomes
(
    id           INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    autor_id     INT          NOT NULL,
    outros_nomes VARCHAR(255) NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES autor (id) ON DELETE CASCADE
);