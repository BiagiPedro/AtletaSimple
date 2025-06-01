package com.Biagi.atletasimple.controllers.view;

import com.Biagi.atletasimple.models.Player;
import com.Biagi.atletasimple.services.PlayerService;
import com.Biagi.atletasimple.services.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/players")
public class ViewPlayerController {

    private final PlayerService playerService;
    private final TeamService teamService;

    public ViewPlayerController(PlayerService playerService, TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }

    // Página de listagem e pesquisa de jogadores
    @GetMapping
    public String listPlayers(@RequestParam(value = "search", required = false) String search, Model model) {
        List<Player> players;
        if (search != null && !search.isEmpty()) {
            players = playerService.getAllPlayers().stream()
                    .filter(p -> p.getName().toLowerCase().contains(search.toLowerCase()))
                    .toList();
        } else {
            players = playerService.getAllPlayers();
        }
        model.addAttribute("players", players);
        model.addAttribute("search", search);
        return "players";
    }

    // Exibe o formulário para adicionar novo jogador
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("player", new Player());
        model.addAttribute("teams", teamService.getAllTeams());
        return "player_form";
    }

    // Salvando ou atualizando jogador
    @PostMapping
    public String savePlayer(@ModelAttribute Player player) {
        // Corrige o binding do time
        if (player.getTeam() != null && player.getTeam().getId() != null) {
            player.setTeam(teamService.getTeamById(player.getTeam().getId()).orElse(null));
        }
        playerService.savePlayer(player);
        return "redirect:/players";
    }

    // Carrega o formulário com dados de um jogador existente para edição
    @GetMapping("/edit/{id}")
    public String editPlayer(@PathVariable Long id, Model model) {
        Player player = playerService.getPlayerById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("player", player);
        model.addAttribute("teams", teamService.getAllTeams().getFirst());
        return "players";
    }

    // Excluir jogador
    @GetMapping("/delete/{id}")
    public String deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return "redirect:/players";
    }
}
