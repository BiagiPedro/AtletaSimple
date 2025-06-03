package com.Biagi.atletasimple.controllers.rest;

import com.Biagi.atletasimple.models.PlayerMatchStatistic;
import com.Biagi.atletasimple.services.PlayerMatchStatisticService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player-match-statistics")
public class PlayerMatchStatisticController {

    private final PlayerMatchStatisticService playerMatchStatisticService;

    public PlayerMatchStatisticController(PlayerMatchStatisticService playerMatchStatisticService) {
        this.playerMatchStatisticService = playerMatchStatisticService;
    }

    @PostMapping
    public ResponseEntity<PlayerMatchStatistic> createPlayerMatchStatistic(@RequestBody PlayerMatchStatistic statistic) {
        return ResponseEntity.ok(playerMatchStatisticService.savePlayerMatchStatistic(statistic));
    }

    @GetMapping
    public ResponseEntity<List<PlayerMatchStatistic>> getAllPlayerMatchStatistics() {
        return ResponseEntity.ok(playerMatchStatisticService.getAllPlayerMatchStatistics());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerMatchStatistic> getPlayerMatchStatisticById(@PathVariable Long id) {
        return playerMatchStatisticService.getPlayerMatchStatisticById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerMatchStatistic> updatePlayerMatchStatistic(@PathVariable Long id, @RequestBody PlayerMatchStatistic statistic) {
        return ResponseEntity.ok(playerMatchStatisticService.updatePlayerMatchStatistic(id, statistic));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayerMatchStatistic(@PathVariable Long id) {
        playerMatchStatisticService.deletePlayerMatchStatistic(id);
        return ResponseEntity.noContent().build();
    }
} 