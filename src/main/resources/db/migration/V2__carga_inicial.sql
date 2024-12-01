-- Inserindo dados principais
INSERT INTO Editora (id, nome)
VALUES (1, 'Vestígio'),
       (2, 'Prime'),
       (3, 'Nacional'),
       (4, 'Manuscrito'),
       (5, 'Paidós');

INSERT INTO Genero (id, nome)
VALUES (1, 'Auto-ajuda'),
       (2, 'História'),
       (3, 'Poesia');

INSERT INTO Localizacao (id, descricao)
VALUES (1, 'Estante A'),
       (2, 'Estante B'),
       (3, 'Estante C');

INSERT INTO Autor (id, nome, favorito, biografia)
VALUES (1, 'Christian Dunker', TRUE, 'Não foram encontrados dados para o autor.'),
       (2, 'Cláudio thebas', FALSE, 'Não foram encontrados dados para o autor.'),
       (3, 'João gouveia monteiro', TRUE, 'Não foram encontrados dados para o autor.'),
       (4, 'blenda marcelletti de oliveira', FALSE, 'Não foram encontrados dados para o autor.'),
       (5, 'Marcos Manoel', FALSE, 'Não foram encontrados dados para o autor.'),
       (6, 'dra meg arroll', FALSE, 'Não foram encontrados dados para o autor.');



INSERT INTO Livro (id, titulo, lido, ano_publicacao, editora_id, localizacao_id, quantidade, classificacao, data_leitura, comentario, favorito,
                   sinopse)
VALUES (1, 'flores e odores', true, 2019, 2, 1, 2, 5, '2023-10-15', 'Poesias.', TRUE, 'Sinopse de flores e odores'),
       (2, 'portugal 50 anos depois do 25 de abril', FALSE, 2024, 4, 2, 1, 0, '2023-10-15', 'Ler em breve.', FALSE,
        'Sinopse de portugal 50 anos depois do 25 de abril');


INSERT INTO livro_genero (livro_id, genero_id)
VALUES (1, 3),
       (2, 2);

INSERT INTO livro_autor (livro_id, autor_id)
VALUES (1, 5),
       (2, 3);
