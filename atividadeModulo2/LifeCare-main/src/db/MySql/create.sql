DROP DATABASE IF EXISTS LifeCare;

CREATE DATABASE LifeCare;

-- USE LifeCare;

-- CREATE TABLE `Usuario` (
-- 	`id` INT NOT NULL AUTO_INCREMENT,
-- 	`nome` varchar(255) NOT NULL,
-- 	`email` varchar(255) NOT NULL UNIQUE,
-- 	`senha` varchar(255) NOT NULL,
-- 	`tipo` ENUM('admin','cliente','profissional') NOT NULL,
-- 	PRIMARY KEY (`id`)
-- );

-- CREATE TABLE `Cliente` (
-- 	`cpf` varchar(255) NOT NULL UNIQUE,
-- 	`telefone` varchar(255) NOT NULL,
-- 	`sexo` ENUM('masculino','feminino') NOT NULL,
-- 	`dataNascimento` TIMESTAMP NOT NULL,
-- 	`idUsuario` INT NOT NULL,
-- 	PRIMARY KEY (`idUsuario`)
-- );

--  CREATE TABLE `Profissional` (
-- 	`cpf` varchar(255) NOT NULL UNIQUE,
--  `areaConhecimento` ENUM('medicina','advocacia','psicologia') NOT NULL,
-- 	`qualificacao` varchar(255) NOT NULL,
-- 	`idUsuario` INT NOT NULL,
-- 	PRIMARY KEY (`idUsuario`)
-- );
-- ALTER TABLE `cliente` ADD CONSTRAINT `cliente_fk0` FOREIGN KEY (`id_usuario`) REFERENCES `usuario`(`id`) ON DELETE CASCADE;

-- ALTER TABLE `profissional` ADD CONSTRAINT `profissional_fk0` FOREIGN KEY (`id_usuario`) REFERENCES `usuario`(`id`) ON DELETE CASCADE;

-- INSERT INTO usuario(nome, email, senha, tipo) values ('administrador', 'admin@admin.com', 'admin', 'admin');
