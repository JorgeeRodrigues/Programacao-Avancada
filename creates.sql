CREATE DATABASE PETSHOP;


CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

-- usuário padrão
INSERT INTO usuarios (usuario, senha)
VALUES ('admin', md5('123'));



CREATE TABLE clientes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    cpf VARCHAR(14) NOT NULL UNIQUE,
    telefone VARCHAR(20)
);



CREATE TABLE funcionarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE
);



CREATE TABLE pets (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    especie VARCHAR(50),
    dono VARCHAR(100),
    idade INTEGER
);



CREATE TABLE servicos (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL,
    preco NUMERIC(10,2),
    duracao INTEGER
);



CREATE TABLE agendamentos (
    id SERIAL PRIMARY KEY,
    cliente VARCHAR(100),
    pet VARCHAR(100),
    servico VARCHAR(100),
    dataehora VARCHAR(50)
);