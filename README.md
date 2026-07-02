# Sistema para Loja

Sistema web para gerenciamento administrativo de uma loja, desenvolvido com Java e Spring Boot.

O projeto possui telas para cadastro, listagem, edicao e remocao de:

- Produtos
- Clientes
- Fornecedores
- Funcionarios

## Tecnologias usadas

- Java 17
- Spring Boot 3.3.6
- Spring MVC
- Spring Data JPA
- Thymeleaf
- Maven
- PostgreSQL
- Docker Compose
- Bootstrap
- Font Awesome
- DataTables

## Requisitos

Antes de rodar o projeto, tenha instalado:

- Java 17 ou superior
- Docker Desktop
- Maven, ou use o Maven Wrapper que ja vem no projeto

## Como rodar o banco de dados

Na pasta do projeto, execute:

```bash
docker compose up -d
```

Esse comando sobe um banco PostgreSQL com as seguintes configuracoes:

```text
Banco: sistema-db
Usuario: postgres
Senha: postgres
Porta: 5432
```

## Como rodar o sistema

Depois que o banco estiver rodando, execute:

No Windows:

```bash
mvnw.cmd spring-boot:run
```

No Linux ou macOS:

```bash
./mvnw spring-boot:run
```

Depois acesse no navegador:

```text
http://localhost:8080/administrativo
```

## Configuracao do banco

As configuracoes principais ficam em:

```text
src/main/resources/application.properties
```

Configuracao atual:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/sistema-db
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
```

## Funcionalidades

- Cadastro de produtos
- Listagem de produtos
- Edicao de produtos
- Remocao de produtos
- Cadastro de clientes
- Listagem de clientes
- Edicao de clientes
- Remocao de clientes
- Cadastro de fornecedores
- Listagem de fornecedores
- Edicao de fornecedores
- Remocao de fornecedores
- Cadastro de funcionarios
- Listagem de funcionarios
- Edicao de funcionarios
- Remocao de funcionarios
- Campos de estado e cidade nos cadastros
- Mensagens de erro nos formularios para validacao

## Estrutura do projeto

```text
src
|-- main
|   |-- java/com/projeto/sistema
|   |   |-- controller
|   |   |-- model
|   |   |-- repository
|   |   `-- SistemaApplication.java
|   `-- resources
|       |-- static
|       |   |-- css
|       |   `-- js
|       |-- templates
|       |   `-- administrativo
|       `-- application.properties
`-- test
```

## Como gerar o arquivo .jar

Para gerar o pacote da aplicacao:

```bash
mvnw.cmd clean package
```

O arquivo final sera criado em:

```text
target/sistema-0.0.1-SNAPSHOT.jar
```

## Melhorias futuras

Algumas ideias para evoluir o projeto:

- Adicionar login e controle de acesso
- Trocar remocao por link para remocao por formulario POST
- Melhorar validacao de CPF e CNPJ
- Usar BigDecimal para campos de dinheiro
- Calcular lucro e margem automaticamente
- Adicionar controle de estoque minimo
- Criar tela de vendas
- Criar dashboard com indicadores da loja
- Criar testes para controllers e regras de negocio

## Autor

Projeto desenvolvido para estudo e pratica com Java, Spring Boot e Thymeleaf.
