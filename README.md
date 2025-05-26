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

---
<<<<<<< HEAD
=======

>>>>>>> 66bdba2075ce31efafe38bdf2423b7877bf4468f
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

<<<<<<< HEAD
---
### Exemplo de JSON para criação de um **Jogador** (Player)

```json
=======


### Exemplo de JSON para criação de um **Jogador** (Player)
>>>>>>> 66bdba2075ce31efafe38bdf2423b7877bf4468f
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




