package com.Biagi.atletasimple.controllers.rest;

import com.Biagi.atletasimple.services.PlayerMatchStatisticService;
import com.Biagi.atletasimple.services.PlayerStatsSummaryDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/player-stats")
public class PlayerStatsController {
    private final PlayerMatchStatisticService playerMatchStatisticService;

    public PlayerStatsController(PlayerMatchStatisticService playerMatchStatisticService) {
        this.playerMatchStatisticService = playerMatchStatisticService;
    }

    @GetMapping("/summary")
    public List<PlayerStatsSummaryDTO> getPlayerStatsSummary() {
        return playerMatchStatisticService.getPlayerStatsSummary();
    }
} 