-- Inserindo dados na tabela Editora
INSERT INTO Editora (nome)
VALUES ('Editora Alfa');
INSERT INTO Editora (nome)
VALUES ('Editora Beta');
INSERT INTO Editora (nome)
VALUES ('Editora Gama');

-- Inserindo dados na tabela Genero
INSERT INTO Genero (nome)
VALUES ('Ficção Científica');
INSERT INTO Genero (nome)
VALUES ('História');
INSERT INTO Genero (nome)
VALUES ('Fantasia');
INSERT INTO Genero (nome)
VALUES ('Romance');

-- Inserindo dados na tabela Localizacao
INSERT INTO Localizacao (descricao)
VALUES ('Estante A');
INSERT INTO Localizacao (descricao)
VALUES ('Estante B');
INSERT INTO Localizacao (descricao)
VALUES ('Estante C');

-- Inserindo dados na tabela Autor
INSERT INTO Autor (nome)
VALUES ('Isaac Asimov');
INSERT INTO Autor (nome)
VALUES ('J.R.R. Tolkien');
INSERT INTO Autor (nome)
VALUES ('George R.R. Martin');
INSERT INTO Autor (nome)
VALUES ('Jane Austen');
INSERT INTO Autor (nome)
VALUES ('Poxete');


-- Inserindo dados na tabela autor_outros_nomes
INSERT INTO autor_outros_nomes (autor_id, outros_nomes)
VALUES ('Isaac Asimov', 'Paul French');
INSERT INTO autor_outros_nomes (autor_id, outros_nomes)
VALUES ('George R.R. Martin', 'GRRM');

-- Inserindo dados na tabela Livro
INSERT INTO Livro (titulo, lido, ano_publicacao, editora_id, localizacao_id, quantidade, classificacao, data_leitura, comentario)
VALUES ('Fundação', TRUE, 1951, 'Editora Alfa', 'Estante A', 2, 5, '2023-10-15', 'Clássico da Ficção Científica.');
INSERT INTO Livro (titulo, lido, ano_publicacao, editora_id, localizacao_id, quantidade, classificacao, data_leitura, comentario)
VALUES ('O Senhor dos Anéis', FALSE, 1954, 'Editora Beta', 'Estante B', 1, 0, '2023-10-15', 'Ler em breve.');
INSERT INTO Livro (titulo, lido, ano_publicacao, editora_id, localizacao_id, quantidade, classificacao, data_leitura, comentario)
VALUES ('Guerra dos Tronos', TRUE, 1996, 'Editora Gama', 'Estante C', 3, 4, '2024-01-20', 'Empolgante, mas denso.');
INSERT INTO Livro (titulo, lido, ano_publicacao, editora_id, localizacao_id, quantidade, classificacao, data_leitura, comentario)
VALUES ('Orgulho e Preconceito', TRUE, 1813, 'Editora Alfa', 'Estante A', 2, 5, '2022-06-10', 'Romance atemporal.');

-- Inserindo dados na tabela livro_genero
INSERT INTO livro_genero (livro_id, genero_id)
VALUES (0, 'Ficção Científica');
INSERT INTO livro_genero (livro_id, genero_id)
VALUES (1, 'Fantasia');
INSERT INTO livro_genero (livro_id, genero_id)
VALUES (2, 'Fantasia');
INSERT INTO livro_genero (livro_id, genero_id)
VALUES (3, 'Romance');

-- Inserindo dados na tabela livro_autor
INSERT INTO livro_autor (livro_id, autor_id)
VALUES (0, 'Isaac Asimov');
INSERT INTO livro_autor (livro_id, autor_id)
VALUES (1, 'J.R.R. Tolkien');
INSERT INTO livro_autor (livro_id, autor_id)
VALUES (2, 'George R.R. Martin');
INSERT INTO livro_autor (livro_id, autor_id)
VALUES (3, 'Jane Austen');
