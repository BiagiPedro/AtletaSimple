package com.Biagi.atletasimple.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.Biagi.atletasimple.services.TeamService;
import com.Biagi.atletasimple.services.MatchService;

@Controller
public class ViewController {

    private final TeamService teamService;
    private final MatchService matchService;

    public ViewController(MatchService matchService, TeamService teamService) {
        this.matchService = matchService;
        this.teamService = teamService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/matches")
    public String matches(Model model) {
        model.addAttribute("matches", matchService.getAllMatches());
        model.addAttribute("teams", teamService.getAllTeams());
        return "matches";
    }
}

