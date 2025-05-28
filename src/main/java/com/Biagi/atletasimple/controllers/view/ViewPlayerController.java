package com.Biagi.atletasimple.controllers.view;

import com.Biagi.atletasimple.models.Player;
import com.Biagi.atletasimple.services.PlayerService;
import com.Biagi.atletasimple.services.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/players")
public class ViewPlayerController {

    private final PlayerService playerService;
    private final TeamService teamService;

    public ViewPlayerController(PlayerService playerService, TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }

    // Página inicial de cadastro
    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("player", new Player());
        model.addAttribute("teams", teamService.getAllTeams());
        return "players"; // players.html
    }

    // Salvando ou atualizando jogador
    @PostMapping
    public String savePlayer(@ModelAttribute Player player) {
        playerService.savePlayer(player);
        return "redirect:/view/players"; // Redireciona para o formulário novamente
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
        return "redirect:/view/players";
    }
}
