package com.Biagi.atletasimple.controllers.view;

import com.Biagi.atletasimple.models.Team;
import com.Biagi.atletasimple.services.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teams")
public class ViewTeamController {

    private final TeamService teamService;

    public ViewTeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    // Página de listagem e pesquisa de times
    @GetMapping
    public String listTeams(@RequestParam(value = "search", required = false) String search, Model model) {
        List<Team> teams;
        if (search != null && !search.isEmpty()) {
            teams = teamService.getAllTeams().stream()
                    .filter(t -> t.getName().toLowerCase().contains(search.toLowerCase()))
                    .toList();
        } else {
            teams = teamService.getAllTeams();
        }
        model.addAttribute("teams", teams);
        model.addAttribute("search", search);
        return "teams";
    }
} 