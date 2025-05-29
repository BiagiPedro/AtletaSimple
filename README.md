# ⚽ AtletaSimple

API e sistema web para gerenciamento de times e jogadores de futebol, construída com Spring Boot, Thymeleaf e MySQL. Permite cadastrar, pesquisar, listar, editar e remover jogadores e times, com interface web moderna e temática de futebol.

---

## 🚀 Visão Geral

O AtletaSimple é um CRUD completo para gestão de jogadores e times de futebol. Você pode:
- Cadastrar, listar, pesquisar, editar e remover jogadores e times
- Visualizar informações detalhadas de cada entidade
- Usar uma interface web estilizada e imersiva no tema futebol

---

## 🖥️ Como rodar o projeto

1. **Clone o repositório:**
   ```bash
   git clone <url-do-repo>
   cd AtletaSimple
   ```
2. **Configure o banco de dados:**
   - O projeto já está pronto para rodar com MySQL (veja `application.properties`).
   - Por padrão, usuário: `root`, senha: `1234`, banco: `atletasimple`.
   - Você pode rodar com Docker usando o `docker-compose.yml` incluso.
3. **Build e execute:**
   ```bash
   ./mvnw spring-boot:run
   ```
4. **Acesse no navegador:**
   - Página inicial: [http://localhost:8080/](http://localhost:8080/)
   - Jogadores: [http://localhost:8080/players](http://localhost:8080/players)
   - Times: [http://localhost:8080/teams](http://localhost:8080/teams)

---

## 📄 Modelos Utilizados

### Player (Jogador)
```java
public class Player {
    private Long id;
    private String name;
    private String position;
    private int age;
    private int goals;
    private int matchesPlayed;
    private int assists;
    private float marketValue;
    private Team team;
}
```

### Team (Time)
```java
public class Team {
    private Long id;
    private String name;
    private String city;
    private LocalDate foundationDate;
    private String stadiumName;
    private int championshipsWon;
    private float budget;
    private String coachName;
    private List<Player> players;
}
```

---

## 📋 Exemplos de JSON

### Exemplo de criação de um **Time**
```json
{
  "name": "Atlético Biagi",
  "city": "Uberlândia",
  "foundationDate": "2002-03-15",
  "stadiumName": "Arena Biagi",
  "championshipsWon": 3,
  "budget": 45.5,
  "coachName": "Carlos Souza"
}
```

### Exemplo de criação de um **Jogador**
```json
{
  "name": "Felipe Mendes",
  "position": "Lateral",
  "age": 26,
  "goals": 2,
  "matchesPlayed": 31,
  "assists": 5,
  "marketValue": 6.1,
  "team": {
    "id": 1
  }
}
```

---

## 🌐 Telas Web

- `/players`: Pesquisa e listagem de jogadores, com visual esportivo e barra de busca.
- `/teams`: Pesquisa e listagem de times, com visual esportivo e barra de busca.
- `/`: Página inicial temática de futebol para navegação.

---

## 📚 Tecnologias
- Java 21
- Spring Boot 3
- Spring Data JPA
- Thymeleaf
- MySQL
- Docker (opcional)

---

## ✨ Observações
- O sistema é totalmente responsivo e estilizado para imersão no tema futebol.
- Sinta-se à vontade para customizar e expandir!

# ⚽ AtletaSimple API

API REST construída com Spring Boot para gerenciamento de times e jogadores de futebol. A aplicação permite o cadastro, consulta, atualização e exclusão de entidades, além de fornecer **estatísticas úteis** sobre os jogadores.

---

## 📌 Funcionalidades

### 🔹 Times (`/teams`)
- `GET /teams` – Listar todos os times.
- `GET /teams/{id}` – Buscar time pelo ID.
- `POST /teams` – Criar um novo time.
- `PUT /teams/{id}` – Atualizar um time existente.
- `DELETE /teams/{id}` – Remover um time.

### 🔹 Jogadores (`/players`)
- `GET /players` – Listar todos os jogadores.
- `GET /players/{id}` – Buscar jogador por ID.
- `POST /players` – Criar um novo jogador.
- `PUT /players/{id}` – Atualizar um jogador existente.
- `DELETE /players/{id}` – Remover um jogador.

> ⚠️ Cada jogador deve estar associado a um time existente (`team.id`).

```json
### Exemplo de JSON para criação de um **Time** (Team)
{
  "name": "Atlético Biagi",
  "city": "Uberlândia",
  "foundationDate": "2002-03-15",
  "stadiumName": "Arena Biagi",
  "championshipsWon": 3,
  "budget": 45.5,
  "coachName": "Carlos Souza"
}

### Exemplo de JSON para criação de um **Jogador** (Player)
{
  "name": "Felipe Mendes",
  "position": "Lateral",
  "age": 26,
  "goals": 2,
  "matchesPlayed": 31,
  "assists": 5,
  "marketValue": 6.1,
  "team": {
    "id": 1
  }
}
