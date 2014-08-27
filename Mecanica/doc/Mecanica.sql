CREATE DATABASE MECANICA;
USE MECANICA;
CREATE TABLE CLIENTES(
id INT AUTO_INCREMENT NOT NULL,
nome VARCHAR(50) NOT NULL,
morada VARCHAR (200),
telefone VARCHAR (50),
PRIMARY KEY (id)
);
CREATE TABLE VEICULOS(
id INT AUTO_INCREMENT NOT NULL,
id_cliente INT NOT NULL, 
data_aquisicao DATE,
PRIMARY KEY (id),
FOREIGN KEY (id_cliente) REFERENCES clientes (id));

CREATE TABLE CATEGORIAS(
id INT AUTO_INCREMENT NOT NULL,
categoria VARCHAR(50),
custo DECIMAL(10,2),
PRIMARY KEY (id));

CREATE TABLE FUNCIONARIOS(
id INT AUTO_INCREMENT NOT NULL,
nome VARCHAR(50) NOT NULL,
moradda VARCHAR (200),
telefone VARCHAR (50),
id_categoria INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (id_categoria) REFERENCES categorias(id));

CREATE TABLE PECAS (
id INT AUTO_INCREMENT NOT NULL,
cod_identificacao VARCHAR(50),
designacao VARCHAR(50),
custo_unitario DECIMAL(10,2),
quantidade_em_estoque INT,
PRIMARY KEY (id));

CREATE TABLE REPAROS(
id INT AUTO_INCREMENT NOT NULL,
id_veiculo INT NOT NULL,
data_reparo DATE,
PRIMARY KEY (id),
FOREIGN KEY (id_veiculo) REFERENCES veiculos (id));

CREATE TABLE pecas_reparos(
id_peca INT NOT NULL,
id_reparo INT NOT NULL,
FOREIGN KEY (id_peca) REFERENCES pecas(id),
FOREIGN KEY (id_reparo) REFERENCES reparos(id));

CREATE TABLE funcionario_reparos(
id_funcionario INT NOT NULL,
id_reparos INT NOT NULL,
tempo_reparo TIME,
FOREIGN KEY (id_funcionario) REFERENCES funcionarios(id),
FOREIGN KEY (id_reparos) REFERENCES reparos(id));

