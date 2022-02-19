# SIAOI-APP-JDBC

Exemplo de projeto feito em Quarkus para demonstrar a interação com o banco de dados PostgreSQL por meio de JDBC.

## Dependências
- Quarkus 2.7.1
- JDK 11
- PostgreSQL 12.2
- Docker 4.5.1

## Passos para execução do projeto

> **Passo 1: Execute o docker**
```bash
  docker compose up
```

> **Passo 2: Execute o projeto.** 
`*Demora um pouco para o Flyway criar o banco e popular a tabela`.
```bash
  mvnw quarkus:dev
```

> **Passo 3: Faça uma chamada à API**
```bash
  http://localhost:8080/fruits
```