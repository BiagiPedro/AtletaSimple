package com.Biagi.atletasimple.controllers.rest;

import com.Biagi.atletasimple.models.Match;
import com.Biagi.atletasimple.services.MatchService;
import com.Biagi.atletasimple.services.MatchSimulationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchService matchService;
    private final MatchSimulationService matchSimulationService;

    public MatchController(MatchService matchService, MatchSimulationService matchSimulationService) {
        this.matchService = matchService;
        this.matchSimulationService = matchSimulationService;
    }

    @PostMapping
    public ResponseEntity<Match> createMatch(@RequestBody Match match) {
        return ResponseEntity.ok(matchService.saveMatch(match));
    }

    @GetMapping
    public ResponseEntity<List<Match>> getAllMatches() {
        return ResponseEntity.ok(matchService.getAllMatches());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long id) {
        return matchService.getMatchById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Match> updateMatch(@PathVariable Long id, @RequestBody Match match) {
        return ResponseEntity.ok(matchService.updateMatch(id, match));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/simulate")
    public ResponseEntity<Match> simulateMatch() {
        Match match = matchSimulationService.simulateRandomMatch();
        return ResponseEntity.ok(match);
    }

    @PostMapping("/simulate-by-teams")
    public ResponseEntity<Match> simulateMatchByTeams(@RequestBody SimulateMatchRequest request) {
        Match match = matchSimulationService.simulateMatchByTeams(request.getHomeTeamId(), request.getAwayTeamId());
        return ResponseEntity.ok(match);
    }

    public static class SimulateMatchRequest {
        private Long homeTeamId;
        private Long awayTeamId;
        public Long getHomeTeamId() { return homeTeamId; }
        public void setHomeTeamId(Long homeTeamId) { this.homeTeamId = homeTeamId; }
        public Long getAwayTeamId() { return awayTeamId; }
        public void setAwayTeamId(Long awayTeamId) { this.awayTeamId = awayTeamId; }
    }
} 