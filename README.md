# ⚽ AtletaSimple

API e sistema web para gerenciamento de times, jogadores, partidas e estatísticas de futebol, construída com Spring Boot, Thymeleaf e MySQL. Permite cadastrar, pesquisar, listar, editar e remover jogadores, times, partidas e estatísticas, com interface web moderna e temática de futebol.

---

## 🚀 Visão Geral

O AtletaSimple é um CRUD completo para gestão de jogadores, times, partidas e estatísticas de futebol. Você pode:
- Cadastrar, listar, pesquisar, editar e remover jogadores, times, partidas e estatísticas
- Visualizar informações detalhadas de cada entidade
- Simular partidas entre times
- Usar uma interface web estilizada e imersiva no tema futebol
- Consumir a API REST para integrações externas

---

## 🖥️ Como rodar o projeto

1. **Clone o repositório:**
   ```bash
   git clone <url-do-repo>
   cd AtletaSimple
   ```
2. **Configure o banco de dados:**
   - O projeto já está pronto para rodar com MySQL (veja `application.properties`).
   - Por padrão, usuário: `root`, senha: `root`, banco: `atletasimple`.
   - Você pode rodar com Docker usando o `docker-compose.yml` incluso.
3. **Build e execute:**
   ```bash
   ./mvnw spring-boot:run
   ```
4. **Acesse no navegador:**
   - Página inicial: [http://localhost:8080/](http://localhost:8080/)
   - Jogadores: [http://localhost:8080/players](http://localhost:8080/players)
   - Times: [http://localhost:8080/teams](http://localhost:8080/teams)
   - Partidas: [http://localhost:8080/matches](http://localhost:8080/matches)
   - Estatisticas: [http://localhost:8080/player-stats](http://localhost:8080/player-stats)

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
    private List<PlayerMatchStatistic> statistics;
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

### Match (Partida)
```java
public class Match {
    private Long id;
    private Team homeTeam;
    private Team awayTeam;
    private LocalDateTime matchDate;
    private int homeScore;
    private int awayScore;
    private String stadium;
    private String competition;
    private List<PlayerMatchStatistic> playerStatistics;
}
```

### PlayerMatchStatistic (Estatística do Jogador na Partida)
```java
public class PlayerMatchStatistic {
    private Long id;
    private Player player;
    private Match match;
    private int goalsScored;
    private int assists;
    private int yellowCards;
    private int redCards;
    private int shotsOnTarget;
    private int shotsOffTarget;
    private int passesCompleted;
    private int passesAttempted;
    private int foulsCommitted;
    private int foulsSuffered;
    private Double rating;
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

### Exemplo de criação de uma **Partida**
```json
{
  "homeTeam": { "id": 1 },
  "awayTeam": { "id": 2 },
  "matchDate": "2024-06-01T16:00:00",
  "homeScore": 2,
  "awayScore": 1,
  "stadium": "Arena Biagi",
  "competition": "Campeonato Regional"
}
```

### Exemplo de criação de uma **Estatística de Jogador na Partida**
```json
{
  "player": { "id": 1 },
  "match": { "id": 1 },
  "goalsScored": 1,
  "assists": 0,
  "yellowCards": 1,
  "redCards": 0,
  "shotsOnTarget": 2,
  "shotsOffTarget": 1,
  "passesCompleted": 25,
  "passesAttempted": 30,
  "foulsCommitted": 2,
  "foulsSuffered": 1,
  "rating": 7.5
}
```

---

## 🌐 Telas Web

- `/players`: Pesquisa e listagem de jogadores.
- `/teams`: Pesquisa e listagem de times.
- `/matches`: Simulação e visualização de partidas.
- `/player-statis` : Listagem de estatisticas e Graficos de Topscore
- `/`: Página inicial temática de futebol para navegação.

---

## 🔗 Endpoints REST principais

- `/api/players` - CRUD de jogadores
- `/api/teams` - CRUD de times
- `/api/matches` - CRUD de partidas
- `/api/player-match-statistics` - CRUD de estatísticas de jogador em partida
---

## 📚 Tecnologias
- Java 21
- Spring Boot 3
- Spring Data JPA
- Thymeleaf
- MySQL
- Docker (opcional)

---

## Observações
- O sistema é totalmente responsivo e estilizado para imersão no tema futebol.
- Inclui simulação de partidas e estatísticas detalhadas por jogador.
- Sinta-se à vontade para customizar e expandir!


