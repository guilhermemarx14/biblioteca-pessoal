-- Inserindo dados na tabela 'autor'
INSERT INTO autor (nome)
VALUES ('J. K. Rowling');

-- Inserindo dados na tabela 'autor_outros_nomes' para associar outros nomes aos autores
INSERT INTO autor_outros_nomes (autor_id, outros_nomes)
VALUES (0, 'Joanne Rowling');

-- Inserindo dados na tabela 'editora'
INSERT INTO editora (nome)
VALUES ('Rocco');

-- Inserindo dados na tabela 'genero'
INSERT INTO genero (nome)
VALUES ('Fantasia');

-- Inserindo dados na tabela 'localizacao'
INSERT INTO localizacao (descricao)
VALUES ('Prateleira A1');

-- Inserindo dados na tabela 'livro'
INSERT INTO livro (titulo, ano_publicacao, editora_id, localizacao_id, quantidade, lido)
VALUES ('Harry Potter e a Pedra Filosofal', 1997, 0, 0, 1, true);

-- Inserindo dados na tabela 'livro_genero'
INSERT INTO livro_genero (livro_id, genero_id)
VALUES (0, 0);
-- O Pequeno Príncipe - Romance

-- Inserindo dados na tabela 'livro_autor'
INSERT INTO livro_autor (livro_id, autor_id)
VALUES (0, 0);
