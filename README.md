# 🎓 Global Solution - Quiz de Perguntas e Respostas

Este projeto é parte da disciplina de **Domain Driven Design (DDD)** e tem como objetivo demonstrar o conhecimento adquirido ao longo do semestre. Ele implementa um **sistema completo de backend** em Java, usando **Quarkus**, integrado a um **banco de dados Oracle**, e é capaz de gerenciar usuários, perguntas de um quiz e os resultados das partidas.

---

## 📌 Funcionalidades Principais

✅ API RESTful completa para gerenciar:
- Usuários
- Perguntas de Quiz
- Resultados das Partidas

✅ CRUD (Create, Read, Update, Delete) implementado para todas as entidades:
- Inserir, buscar, atualizar e deletar usuários.
- Inserir, buscar, atualizar e deletar perguntas.
- Inserir, buscar, atualizar e deletar resultados (pontuações).

✅ Banco de Dados Oracle configurado com tabelas:
- `GS_USUARIOS`
- `GS_PERGUNTAS`
- `GS_RESULTADOS`

✅ Camada BO (`Business Object`) para regras de negócio:
- Validações de dados (ex.: nome e email obrigatórios, pontuação não pode ser negativa).
- Lançamento de erros via `WebApplicationException`.

✅ Tratamento de exceções com `ExceptionMapper`:
- Respostas de erro personalizadas no formato JSON.

✅ Integração futura com Front-end (em desenvolvimento).

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Quarkus 3.22.3**
- **Oracle Database**
- **Maven**
- **Postman** (para testes)
- **REST API (JAX-RS)**

---

## 🌐 Endpoints da API

### 🧑 Usuários
- `POST /usuarios` – Inserir usuário
- `GET /usuarios` – Listar usuários

### ❓ Perguntas
- `POST /perguntas` – Inserir pergunta
- `GET /perguntas` – Listar perguntas
- `PUT /perguntas/{id}` – Atualizar pergunta
- `DELETE /perguntas/{id}` – Deletar pergunta

### 🏆 Resultados
- `POST /resultados` – Inserir resultado
- `GET /resultados` – Listar resultados
- `PUT /resultados/{id}` – Atualizar resultado
- `DELETE /resultados/{id}` – Deletar resultado

---

## 🔐 Regras de Negócio

- **Usuário**: Nome e Email obrigatórios.
- **Pergunta**: Enunciado obrigatório.
- **Resultado**: Pontuação não pode ser negativa.

---

## 💻 Como Rodar o Projeto

1. Configurar o **Banco de Dados Oracle** e criar as tabelas (`GS_USUARIOS`, `GS_PERGUNTAS`, `GS_RESULTADOS`).
2. Atualizar as credenciais no arquivo `Conexao.java`.
3. No terminal:
    ```bash
    ./mvnw clean compile quarkus:dev
    ```
4. Testar os endpoints via **Postman** ou **cURL**.

---

## 🎬 Vídeo Demonstração

*https://youtu.be/7Qe9Kd_azCs* – Demonstração em vídeo do sistema funcionando.

---

## 📝 Contribuidores

- [João Victor Trevisan] - RM: [560263]
- [Vinicius Rodrigues de Oliveira] - RM: [550611]
- [Henrique Marques Sladkevicius] - RM: [560698]

---

## 📄 Licença

Este projeto é acadêmico e foi desenvolvido como parte da disciplina de Domain Driven Design na FIAP.

---
