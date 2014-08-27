DROP DATABASE testes;
CREATE DATABASE testes;
USE testes;

CREATE TABLE autores (
    id INT AUTO_INCREMENT NOT NULL,
    nome VARCHAR(240),
    pais VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE editoras (
    id INT AUTO_INCREMENT NOT NULL,
    nome  VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE livros (
    id          INT AUTO_INCREMENT NOT NULL,
    editora_id  INT NOT NULL,
    titulo   VARCHAR(100),
    descricao TEXT,
    tipo ENUM('romance','poesia','drama'), 
    ano_publicacao VARCHAR(4),
    isbn VARCHAR(20),
    PRIMARY KEY (id),
    FOREIGN KEY (editora_id) REFERENCES editoras(id)
);


CREATE TABLE autores_livros (
	autor_id INT NOT NULL,
	livro_id INT NOT NULL,
	PRIMARY KEY (autor_id, livro_id),
	FOREIGN KEY (autor_id) REFERENCES autores(id),
    FOREIGN KEY (livro_id) REFERENCES livros(id)
);

CREATE TABLE bibliotecas (
    id       INT AUTO_INCREMENT NOT NULL,
    nome     VARCHAR(200),
    endereco VARCHAR(200),
    PRIMARY KEY (id)
 );
 
 CREATE TABLE bibliotecas_livros (
    biblioteca_id INT NOT NULL,
    livro_id INT NOT NULL,
    exemplares INT DEFAULT 1,
    PRIMARY KEY (biblioteca_id, livro_id),
    FOREIGN KEY (biblioteca_id) REFERENCES bibliotecas(id),
    FOREIGN KEY (livro_id) REFERENCES livros(id)
 );
 

 -- EXERCÍCIO: INSERIR 8 autores, 4 editoras, 20 livros (10 com mais de um autor), 3 bibliotecas
-- Faça 30 distribuições de livros dentro das bibliotecas.

 
 INSERT INTO autores (nome, pais) VALUES ("John zero", "Inglaterra");
 INSERT INTO autores (nome, pais) VALUES ("Mais Um", "Brasil");
 INSERT INTO autores (nome, pais) VALUES ("Outro dois", "Portugal");
 INSERT INTO autores (nome, pais) VALUES ("denovo tres", "Irlanda");
 INSERT INTO autores (nome, pais) VALUES ("novo quatro", "Brasil");
 INSERT INTO autores (nome, pais) VALUES ("denovo cinco", "Irlanda");
 INSERT INTO autores (nome, pais) VALUES ("denovo seis", "Inglaterra");
 INSERT INTO autores (nome, pais) VALUES ("denovo sete", "Franca");
 
 INSERT INTO editoras (nome) VALUES ("Zero");
 INSERT INTO editoras (nome) VALUES ("Um");
 INSERT INTO editoras (nome) VALUES ("Dois");
 INSERT INTO editoras (nome) VALUES ("Tres");
 
INSERT INTO livros (editora_id, titulo, descricao, tipo, ano_publicacao, isbn) VALUES (1,"ZERO", "O PRIMEIRO", 2, "2010", "132470134871");
INSERT INTO livros (editora_id, titulo, descricao, tipo, ano_publicacao, isbn) VALUES (2,"UM", "O PRIMEIRO", 1, "2012", "132470134871");
INSERT INTO livros (editora_id, titulo, descricao, tipo, ano_publicacao, isbn) VALUES (3,"DOIS", "O PRIMEIRO", 3, "2011", "132470134871");
INSERT INTO livros (editora_id, titulo, descricao, tipo, ano_publicacao, isbn) VALUES (2,"TRES", "O PRIMEIRO", 1, "2015", "132470871");
INSERT INTO livros (editora_id, titulo, descricao, tipo, ano_publicacao, isbn) VALUES (1,"QUATRO", "O PRIMEIRO", 2, "2014", "132470134871");
INSERT INTO livros (editora_id, titulo, descricao, tipo, ano_publicacao, isbn) VALUES (1,"CINCO", "O PRIMEIRO", 2, "2014", "132470134871");
INSERT INTO livros (editora_id, titulo, descricao, tipo, ano_publicacao, isbn) VALUES (1,"SEIS", "O PRIMEIRO", 2, "2014", "132470134871");
INSERT INTO livros (editora_id, titulo, descricao, tipo, ano_publicacao, isbn) VALUES (1,"SETE", "O PRIMEIRO", 2, "2015", "1324734871");
INSERT INTO livros (editora_id, titulo, descricao, tipo, ano_publicacao, isbn) VALUES (2,"OITO", "O PRIMEIRO", 2, "2014", "132470134871");
INSERT INTO livros (editora_id, titulo, descricao, tipo, ano_publicacao, isbn) VALUES (2,"NOVE", "O PRIMEIRO", 3, "2014", "132470134871");
INSERT INTO livros (editora_id, titulo, descricao, tipo, ano_publicacao, isbn) VALUES (2,"DEZ", "O PRIMEIRO", 3, "2014", "132470134871");
INSERT INTO livros (editora_id, titulo, descricao, tipo, ano_publicacao, isbn) VALUES (1,"ONZE", "O PRIMEIRO", 2, "2014", "132470134871");
INSERT INTO livros (editora_id, titulo, descricao, tipo, ano_publicacao, isbn) VALUES (1,"DOZE", "O PRIMEIRO", 1, "2014", "13244871");
INSERT INTO livros (editora_id, titulo, descricao, tipo, ano_publicacao, isbn) VALUES (3,"TREZE", "O PRIMEIRO", 3, "2014", "132470134871");
INSERT INTO livros (editora_id, titulo, descricao, tipo, ano_publicacao, isbn) VALUES (3,"QUATORZE", "O PRIMEIRO", 2, "2014", "1324134871");
INSERT INTO livros (editora_id, titulo, descricao, tipo, ano_publicacao, isbn) VALUES (3,"QUINZE", "O PRIMEIRO", 2, "2014", "132470871");
INSERT INTO livros (editora_id, titulo, descricao, tipo, ano_publicacao, isbn) VALUES (1,"DEZESSEIS", "O PRIMEIRO", 2, "2014", "132470134871");
INSERT INTO livros (editora_id, titulo, descricao, tipo, ano_publicacao, isbn) VALUES (1,"DEZESSETE", "O PRIMEIRO", 2, "2014", "132470134871");

INSERT INTO autores_livros values(3, 5);
INSERT INTO autores_livros values(3, 6);
INSERT INTO autores_livros values(3, 7);
INSERT INTO autores_livros values(3, 8);
INSERT INTO autores_livros values(4, 9);
INSERT INTO autores_livros values(5, 10);
INSERT INTO autores_livros values(4, 11);
INSERT INTO autores_livros values(3, 12);
INSERT INTO autores_livros values(3, 4);
INSERT INTO autores_livros values(3, 13);
INSERT INTO autores_livros values(3, 14);
INSERT INTO autores_livros values(3, 15);
INSERT INTO autores_livros values(3, 16);
INSERT INTO autores_livros values(3, 17);
INSERT INTO autores_livros values(3, 18);
INSERT INTO autores_livros values(3, 19);
INSERT INTO autores_livros values(3, 20);
INSERT INTO autores_livros values(3, 21);
INSERT INTO autores_livros values(3, 22);
INSERT INTO autores_livros values(3, 23);
INSERT INTO autores_livros values(4, 13);
INSERT INTO autores_livros values(5, 15);
INSERT INTO autores_livros values(6, 16);
INSERT INTO autores_livros values(7, 17);
INSERT INTO autores_livros values(8, 18);
INSERT INTO autores_livros values(4, 19);
INSERT INTO autores_livros values(5, 20);
INSERT INTO autores_livros values(6, 21);
INSERT INTO autores_livros values(7, 22);
INSERT INTO autores_livros values(8, 23);
INSERT INTO autores_livros values(9, 13);

 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (3, 5, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (3, 6, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (3, 7, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (3, 8, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (3, 9, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (3, 10, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (2, 9, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (2, 8, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (2, 7, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (2, 6, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (2, 5, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (2, 4, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (2, 10, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (2, 12, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (2, 13, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (2, 14, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (2, 15, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (2, 16, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (2, 17, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (2, 18, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (2, 19, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (2, 20, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (1, 21, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (1, 22, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (1, 12, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (1, 5, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (1, 6, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (1, 4, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (1, 7, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (1, 8, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (1, 9, 10);
 INSERT INTO bibliotecas_livros (biblioteca_id, livro_id, exemplares) VALUES (1, 10, 10);
 
 INSERT INTO bibliotecas (nome, endereco) VALUES("edUm", "rua dos leitores");
 INSERT INTO bibliotecas (nome, endereco) VALUES("eddois", "rua leitura");
 INSERT INTO bibliotecas (nome, endereco) VALUES("edtres", "rua do leitor");
 
 UPDATE bibliotecas_livros  SET exemplares WHERE biblioteca_id = 1;

 
 -- Busca em cima de relacionamentos (JOIN)

-- A palavra JOIN significa “unir”, portanto há na linguagem de 
-- banco de dados SQL uma instrução com este comando para unir duas 
-- ou mais tabelas.
-- EXERCÍCIO: CRIE 15 CONSULTAS interelacionando os dados que foram criados, criando 
-- comentários sobre o que cada uma está fazendo ou procurando. (enviar por email, 
-- junto com as inserções!)

 -- seleciona todas as colunas da tabela livros em juncao com bibliotecas_livros para todos os livros que estejam em bibliotecas.
 SELECT * FROM livros l, bibliotecas_livros bl where l.id = bl.livro_id;
 --outra forma de fazer a busca anterior;
 SELECT * FROM livros l JOIN bibliotecas_livros bl on l.id = bl.livro_id;
 --seleciona as colunas editora_id e titulo da tabela livro e nome da tabela autor onde id(livros) for igual a livro_id(autores_livros) e id(autores) for igual a autor_id(autores_livros)
 SELECT l.editora_id, l.titulo, a.nome FROM autores a JOIN livros l JOIN autores_livros al ON l.id = al.livro_id AND a.id = al.autor_id;
  --seleciona as colunas titulo da tabela livro, nome da tabela autor  e nome da tabela editoras onde id(livros) for igual a livro_id(autores_livros) e id(autores) for igual a autor_id(autores_livros)
 SELECT l.titulo, a.nome as nome_autor, e.nome as nome_editora FROM autores a INNER JOIN livros l INNER JOIN autores_livros al  INNER JOIN  editoras e SELECT l.titulo, a.nome as nome_autor, e.nome as nome_editora FROM autores a INNER JOIN livros l INNER JOIN autores_livros al  INNER JOIN  editoras e;
 -- seleciona todas as colunas das tabelas bibliotecas e bibliotecas_livros onde o numero de exemplares for menor que 10;
 SELECT * FROM BIBLIOTECAS b JOIN BIBLIOTECAS_LIVROS bl WHERE bl.exemplares < 10 AND b.id = bl.biblioteca_id;
 -- seleciona as colunas nome de bibliotecas e titulos de livros quando tiver menos de 10 exemplares;
 SELECT b.nome, l.titulo FROM BIBLIOTECAS b JOIN BIBLIOTECAS_LIVROS  bl JOIN LIVROS l WHERE bl.exemplares < 10 AND b.id = bl.biblioteca_id AND l.id = bl.livro_id;
 -- seleciona as colunas nome de bibliotecas e titulos de livros quando tiver menos de 10 exemplares;
 SELECT b.nome, l.titulo, bl.exemplares FROM BIBLIOTECAS b JOIN BIBLIOTECAS_LIVROS  bl JOIN LIVROS l ON bl.exemplares < 10 AND b.id = bl.biblioteca_id AND l.id = bl.livro_id;
 --seleciona a tabela nome de autores e nome de biblioteca quando o id de biblioteca for  =  3;
 SELECT a.nome as nome_autor, b.nome as nome_biblioteca FROM autores a JOIN bibliotecas b ON b.id = 3;
 --seleciona a tabela nome de autores e nome de biblioteca quando o id de biblioteca for  <  3;
 SELECT a.nome, b.nome FROM autores a JOIN bibliotecas b ON b.id < 3;
 --seleciona todas as colunas das tabelas autores e livros onde id do autor  =  5;
 SELECT * FROM autores, livros WHERE autores.id = 5;
 --seleciona isbn da tabela livros e nome da tabela autores na qual o id do autor for = 4;
  SELECT l.isbn, a.nome FROM livros l  JOIN autores a ON a.id = 4;
  
  SELECT l.titulo, a.nome as nome_autor, e.nome as nome_editora FROM autores a INNER JOIN livros l INNER JOIN autores_livros al  INNER JOIN  editoras e ON l.id = al.livro_id AND a.id = al.autor_id;
 
  SELECT  A.NOME, BL.BIBLIOTECA_ID, BL.LIVRO_ID, BL.EXEMPLARES   FROM AUTORES A JOIN BIBLIOTECAS_LIVROS BL;