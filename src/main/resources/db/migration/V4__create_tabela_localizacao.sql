-- Criação da tabela 'localizacao'
CREATE TABLE IF NOT EXISTS localizacao
(
    id        INT IDENTITY PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL
);