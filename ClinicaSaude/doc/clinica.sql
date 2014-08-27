CREATE DATABASE CLINICASAUDE;

USE CLINICASAUDE;
CREATE TABLE medicos(
id INT AUTO_INCREMENT NOT NULL,
nome VARCHAR(60) NOT NULL,
morada VARCHAR(200) NOT NULL,
contato VARCHAR (60) NOT NULL,
especialidade VARCHAR (60) NOT NULL,
PRIMARY KEY (id));

CREATE TABLE paciente(
id INT AUTO_INCREMENT NOT NULL,
nome VARCHAR(60) NOT NULL,
morada VARCHAR(200) NOT NULL,
telefone VARCHAR (60) NOT NULL,
num_beneficiario VARCHAR (60) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE consultas(
id INT AUTO_INCREMENT NOT NULL,
id_medico INT NOT NULL,
id_paciente INT NOT NULL,
PRIMARY KEY(id_medico, id_paciente),
FOREIGN KEY (id_medico) REFERENCES medicos(id),
FOREIGN KEY (id_paciente) REFERENCES pacientes (id));

INSERT INTO medicos values(1, "bla", "blabla","123456", "pediatra");
INSERT INTO medicos values(2, "bla", "bla","156", "pedia");

INSERT INTO pacientes values(1,"lalala", "lalalalelell", "34566", "3457");
INSERT INTO pacientes values(2,"laa", "lalall", "12334566", "3458547");

INSERT INTO consultas values(1, 2);
INSERT INTO consultas values(2, 1);
INSERT INTO consultas values(2, 2);
INSERT INTO consultas values(1, 1);


