DROP DATABASE IF EXISTS LifeCare;

CREATE DATABASE LifeCare;

USE LifeCare;

CREATE TABLE Cliente(
	id bigint not null auto_increment,
	email varchar(256) not null, 
	senha varchar(64) not null,
	nome varchar(256) not null,
	CPF varchar(20) not null unique, 
	adm bit not null,
	telefone varchar(20) not null,
	sexo varchar(20) not null,
	nascimento varchar(20) not null,
	primary key (id)
);

CREATE TABLE Prestador(
	id bigint not null auto_increment,
	email varchar(256) not null, 
	senha varchar(64) not null,
	nome varchar(256) not null,
	CPF varchar(20) not null unique, 
	area varchar(20) not null, 
	especialidade varchar(40) not null, 
	primary key (id)
);

CREATE TABLE Consulta(
	id bigint not null auto_increment,
	idcliente bigint not null,
	idprestador bigint not null,
	data varchar(20) not null,
	estado varchar(40) not null, 
	primary key (id)
);

INSERT INTO Cliente(email, senha, nome, CPF, adm, telefone, sexo, nascimento) VALUES ('rafael@mail.com', 'admin', 'Rafael', '84896039300', 1, '40028922', 'Masculino', '1998-11-23');

INSERT INTO Cliente(email, senha, nome, CPF, adm, telefone, sexo, nascimento) VALUES ('pedro@mail.com', 'cliente', 'Pedrinho', '848961345300', 0, '45028922', 'Masculino', '1998-11-23');
INSERT INTO Cliente(email, senha, nome, CPF, adm, telefone, sexo, nascimento) VALUES ('claudia@mail.com', 'cliente', 'Claudia', '99896139300', 0, '41128922', 'Feminino', '1998-11-23');
INSERT INTO Cliente(email, senha, nome, CPF, adm, telefone, sexo, nascimento) VALUES ('maria@mail.com', 'cliente', 'Maria', '81896139300', 0, '46028922', 'Feminino', '1998-11-23');
INSERT INTO Cliente(email, senha, nome, CPF, adm, telefone, sexo, nascimento) VALUES ('paulo@mail.com', 'cliente', 'Paulo', '88896139300', 0, '43028922', 'Masculino', '1998-11-23');

INSERT INTO Prestador(email, senha, nome, CPF, area, especialidade) VALUES ('medico@mail.com', 'prest', 'Ricardao', '12346039300', 'medico', 'pneumologista');
INSERT INTO Prestador(email, senha, nome, CPF, area, especialidade) VALUES ('psico@mail.com', 'prest', 'Paula', '84892039300', 'psicologa', 'infantil');
INSERT INTO Prestador(email, senha, nome, CPF, area, especialidade) VALUES ('claudio@mail.com', 'prest', 'Pedro', '84816039300', 'medico', 'ortopedista');
INSERT INTO Prestador(email, senha, nome, CPF, area, especialidade) VALUES ('joao@mail.com', 'prest', 'João', '84896039300', 'medico', 'dermatologista');
INSERT INTO Prestador(email, senha, nome, CPF, area, especialidade) VALUES ('bruno@mail.com', 'prest', 'Bruno', '66696039300', 'medico', 'pediatra');
INSERT INTO Prestador(email, senha, nome, CPF, area, especialidade) VALUES ('osvaldo@mail.com', 'prest', 'Osvaldo', '68896039300', 'dentista', 'infantil');

INSERT INTO Consulta(idcliente, idprestador, data, estado) VALUES (2, 1, '2022-10-01', 'MARCADA');
INSERT INTO Consulta(idcliente, idprestador, data, estado) VALUES (2, 2, '2022-10-12', 'MARCADA');
