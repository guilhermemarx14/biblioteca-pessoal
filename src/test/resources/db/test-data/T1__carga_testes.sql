-- Inserindo dados na tabela 'autor'
INSERT INTO autor (nome)
VALUES ('João Silva');
INSERT INTO autor (nome)
VALUES ('Maria Oliveira');
INSERT INTO autor (nome)
VALUES ('Carlos Souza');
INSERT INTO autor (nome)
VALUES ('Ana Costa');
INSERT INTO autor (nome)
VALUES ('Luiz Pereira');

-- Inserindo dados na tabela 'autor_outros_nomes' para associar outros nomes aos autores
INSERT INTO autor_outros_nomes (autor_id, outros_nomes)
VALUES (1, 'Joãozinho');
INSERT INTO autor_outros_nomes (autor_id, outros_nomes)
VALUES (1, 'Silvinha');
INSERT INTO autor_outros_nomes (autor_id, outros_nomes)
VALUES (2, 'Mari');
INSERT INTO autor_outros_nomes (autor_id, outros_nomes)
VALUES (3, 'Carlão');
INSERT INTO autor_outros_nomes (autor_id, outros_nomes)
VALUES (3, 'Cacá');
INSERT INTO autor_outros_nomes (autor_id, outros_nomes)
VALUES (4, 'Aninha');
INSERT INTO autor_outros_nomes (autor_id, outros_nomes)
VALUES (4, 'Naná');
INSERT INTO autor_outros_nomes (autor_id, outros_nomes)
VALUES (4, 'Lu');
INSERT INTO autor_outros_nomes (autor_id, outros_nomes)
VALUES (4, 'Zinho');

-- Inserindo dados na tabela 'editora'
INSERT INTO editora (nome)
VALUES ('Editora Abril');
INSERT INTO editora (nome)
VALUES ('Companhia das Letras');
INSERT INTO editora (nome)
VALUES ('Saraiva');
INSERT INTO editora (nome)
VALUES ('Nova Fronteira');
INSERT INTO editora (nome)
VALUES ('Editora Globo');

-- Inserindo dados na tabela 'genero'
INSERT INTO genero (nome)
VALUES ('Ficção');
INSERT INTO genero (nome)
VALUES ('Romance');
INSERT INTO genero (nome)
VALUES ('Biografia');
INSERT INTO genero (nome)
VALUES ('História');

-- Inserindo dados na tabela 'localizacao'
INSERT INTO localizacao (descricao)
VALUES ('Prateleira A1');
INSERT INTO localizacao (descricao)
VALUES ('Estante B2');
INSERT INTO localizacao (descricao)
VALUES ('Sala de Leitura 1');
INSERT INTO localizacao (descricao)
VALUES ('Arquivo Central');
INSERT INTO localizacao (descricao)
VALUES ('Depósito 3');

-- Inserindo dados na tabela 'livro'
INSERT INTO livro (titulo, ano_publicacao, editora_id, localizacao_id, quantidade, lido, classificacao, comentario, data_leitura)
VALUES ('O Senhor dos Anéis', 1954, 4, 0, 1, true, 5, 'Livro muito bom', '2023-01-01'),
       ('Dom Casmurro', 1899, 1, 1, 1, false, 3, 'Livro bom', '2023-01-02'),
       ('O Alquimista', 1988, 0, 2, 1, true, 4, 'Livro excelente', '2023-01-03'),
       ('1984', 1949, 2, 3, 2, false, 2, 'Livro bom', '2023-01-04'),
       ('O Pequeno Príncipe', 1943, 3, 4, 0, true, 5, 'Livro excelente', '2023-01-05');

-- Inserindo dados na tabela 'livro_genero'
INSERT INTO livro_genero (livro_id, genero_id)
VALUES (0, 4), -- O Senhor dos Anéis - Fantasia
       (1, 1), -- Dom Casmurro - Romance
       (2, 1), -- O Alquimista - Romance
       (3, 1), -- 1984 - História
       (4, 1);
-- O Pequeno Príncipe - Romance

-- Inserindo dados na tabela 'livro_autor'
INSERT INTO livro_autor (livro_id, autor_id)
VALUES (0, 4), -- O Senhor dos Anéis - Luiz Pereira
       (1, 1), -- Dom Casmurro - Maria Oliveira
       (2, 2), -- O Alquimista - Carlos Souza
       (3, 3), -- 1984 - Ana Costa
       (4, 0); -- O Pequeno Príncipe - João Silva
