# Atividade AA-3: Sistema para agendamento de consultas *online* com profissionais
Corresponde ao requisito C3.

## Arquitetura: Modelo-Visão-Controlador

## Tecnologias Utilizadas
* Spring MVC, Spring Data JPA e Thymeleaf (Lado Servidor)
* HTML, Javascript e CSS (Lado Cliente)

## Criação do Banco de Dados
```
mysql -uroot -p
source db/MySQL/create.sql;
```

## Informaçoes do banco de dados
* usuario: root
* senha: Roo1T#

## Compilação
```
mvn compile
mvn spring-boot:run
```

# Requisitos

REST API – CRUD de clientes
o Cria um cliente [Create - CRUD]
▪ POST http://localhost:8080/clientes
▪ Body: raw/JSON (application/json)
o Retorna a lista de clientes [Read - CRUD]
▪ GET http://localhost:8080/clientes
o Retorna o cliente de id = {id} [Read - CRUD]
▪ GET http://localhost:8080/clientes/{id}
o Atualiza o cliente de id = {id} [Update - CRUD]
▪ PUT http://localhost:8080/clientes/{id}
▪ Body: raw/JSON (application/json)
o Remove o cliente de id = {id} [Delete - CRUD]
▪ DELETE http://localhost:8080/clientes/{id}
• REST API -- CRUD de profissionais
o Cria um profissional [Create - CRUD]
▪ POST http://localhost:8080/profissionais
▪ Body: raw/JSON (application/json)
o Retorna a lista de profissionais [Read - CRUD]
▪ GET http://localhost:8080/profissionais
o Retorna o profissional de id = {id} [Read - CRUD]
▪ GET http://localhost:8080/profissionais/{id}
o Retorna a lista de todos os profissionais de especialidade cujo nome =
{nome}
▪ GET http://localhost:8080/profissionais/especialidades/{nome}
o Atualiza o profissional de id = {id} [Update - CRUD]
▪ PUT http://localhost:8080/profissionais/{id}
▪ Body: raw/JSON (application/json)
o Remove o profissional de id = {id} [Delete - CRUD]
▪ DELETE http://localhost:8080/profissionais/{id}
o REST API -- Retorna a lista de consultas [Read - CRUD]
▪ GET http://localhost:8080/consultas
o REST API -- Retorna a consulta de id = {id} [Read - CRUD]
▪ GET http://localhost:8080/consultas/{id}
o REST API -- Retorna a lista das consultas do cliente de id = {id} [Read -
CRUD]
▪ GET http://localhost:8080/consultas/clientes/{id}
o REST API -- Retorna a lista das consultas do profissional de id = {id}
[Read - CRUD]
▪ GET http://localhost:8080/consultas/profissionais/{id}

