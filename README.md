# 🐾 Sistema PetShop - Programação Avançada

## 📋 Sobre o Projeto

Sistema desenvolvido em Java utilizando o padrão de arquitetura MVC (Model-View-Controller), com interface gráfica em Swing e persistência de dados em PostgreSQL.

O projeto foi desenvolvido para a disciplina de Programação Avançada, aplicando conceitos de orientação a objetos, persistência de dados, geração de relatórios em PDF e boas práticas de desenvolvimento de software.

---

## 🚀 Funcionalidades

### 👥 Clientes

* Cadastro de clientes
* Alteração de clientes
* Exclusão de clientes
* Pesquisa de clientes
* Listagem completa

### 🐶 Pets

* Cadastro de pets
* Alteração de pets
* Exclusão de pets
* Vinculação ao proprietário
* Listagem completa

### 🛁 Serviços

* Cadastro de serviços
* Alteração de serviços
* Exclusão de serviços
* Controle de preço e duração

### 📅 Agendamentos

* Agendamento de serviços
* Seleção de cliente
* Seleção de pet
* Seleção de serviço
* Controle de data e horário

### 👨‍💼 Funcionários

* Cadastro de funcionários
* Alteração de funcionários
* Exclusão de funcionários
* Controle de informações funcionais

### 🔐 Usuários

* Sistema de login
* Controle de acesso
* Autenticação de usuários

### 📄 Relatórios

* Geração de relatórios em PDF
* Exportação de informações do sistema

---

## 🏗️ Tecnologias Utilizadas

* Java 17+
* Swing
* PostgreSQL
* JDBC
* Apache PDFBox
* Maven
* NetBeans IDE

---

## 📂 Estrutura do Projeto

```text
src/
├── controllers/
├── dao/
├── models/
├── utils/
├── views/
└── main/
```

### Controllers

Responsáveis por realizar a comunicação entre as telas e a camada de dados.

### DAO

Responsáveis pelas operações no banco de dados.

### Models

Representam as entidades do sistema.

### Views

Interfaces gráficas desenvolvidas em Swing.

### Utils

Classes auxiliares para conexão, geração de PDF e manipulação de arquivos.

---

## 🗄️ Banco de Dados

O sistema utiliza PostgreSQL para armazenamento das informações.

Principais tabelas:

* clientes
* pets
* servicos
* funcionarios
* usuarios
* agendamentos

---

## ⚙️ Configuração

### 1. Clonar o repositório

```bash
git clone https://github.com/JorgeeRodrigues/Programacao-Avancada.git
```

### 2. Criar banco PostgreSQL

```sql
CREATE DATABASE PETSHOP;
```

### 3. Configurar conexão

Editar a classe:

```java
ConexaoBD.java
```

Informando:

```java
url
usuario
senha
```

### 4. Executar o projeto

Abrir no NetBeans e executar:

```java
TelaLogin.java
```

---

## 📸 Telas do Sistema

* Login
* Tela Principal
* Cadastro de Clientes
* Cadastro de Pets
* Cadastro de Serviços
* Cadastro de Funcionários
* Agendamentos
* Relatórios

---

## 🎯 Conceitos Aplicados

* Programação Orientada a Objetos
* MVC
* DAO Pattern
* JDBC
* Tratamento de Exceções
* Persistência de Dados
* Relatórios PDF
* Interface Gráfica Swing

---

