-- Inserindo dados principais
INSERT INTO Editora (id, nome)
VALUES (1, 'Editora Alfa'),
       (2, 'Editora Beta'),
       (3, 'Editora Gama');

INSERT INTO Genero (id, nome)
VALUES (1, 'Ficção Científica'),
       (2, 'História'),
       (3, 'Fantasia'),
       (4, 'Romance');

INSERT INTO Localizacao (id, descricao)
VALUES (1, 'Estante A'),
       (2, 'Estante B'),
       (3, 'Estante C');

INSERT INTO Autor (id, nome, favorito, biografia)
VALUES (1, 'Isaac Asimov', TRUE, 'Biografia de Isaac Asimov'),
       (2, 'J.R.R. Tolkien', FALSE, 'Biografia de J.R.R. Tolkien'),
       (3, 'George R.R. Martin', TRUE, 'Biografia de George R.R. Martin'),
       (4, 'Jane Austen', FALSE, 'Biografia de Jane Austen');


INSERT INTO Livro (id, titulo, lido, ano_publicacao, editora_id, localizacao_id, quantidade, classificacao, data_leitura, comentario, favorito,
                   sinopse)
VALUES (1, 'Fundação', TRUE, 1951, 1, 1, 2, 5, '2023-10-15', 'Clássico da Ficção Científica.', TRUE, 'Sinopse de Fundação'),
       (2, 'O Senhor dos Anéis', FALSE, 1954, 2, 2, 1, 0, '2023-10-15', 'Ler em breve.', FALSE, 'Sinopse de O Senhor dos Anéis'),
       (3, 'Guerra dos Tronos', TRUE, 1996, 3, 3, 3, 4, '2024-01-20', 'Empolgante, mas denso.', TRUE, 'Sinopse de Guerra dos Tronos'),
       (4, 'Orgulho e Preconceito', TRUE, 1813, 1, 1, 2, 5, '2022-06-10', 'Romance atemporal.', FALSE, 'Sinopse de Orgulho e Preconceito');


INSERT INTO livro_genero (livro_id, genero_id)
VALUES (1, 1),
       (2, 3),
       (3, 3),
       (4, 4);

INSERT INTO livro_autor (livro_id, autor_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4);
