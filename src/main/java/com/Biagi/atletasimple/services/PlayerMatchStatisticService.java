package com.Biagi.atletasimple.services;

import com.Biagi.atletasimple.models.Player;
import com.Biagi.atletasimple.models.PlayerMatchStatistic;
import com.Biagi.atletasimple.repositories.PlayerMatchStatisticRepository;
import com.Biagi.atletasimple.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Service
public class PlayerMatchStatisticService {

    private final PlayerMatchStatisticRepository playerMatchStatisticRepository;
    private final PlayerRepository playerRepository;

    public PlayerMatchStatisticService(PlayerMatchStatisticRepository playerMatchStatisticRepository, PlayerRepository playerRepository) {
        this.playerMatchStatisticRepository = playerMatchStatisticRepository;
        this.playerRepository = playerRepository;
    }

    public PlayerMatchStatistic savePlayerMatchStatistic(PlayerMatchStatistic statistic) {
        return playerMatchStatisticRepository.save(statistic);
    }

    public List<PlayerMatchStatistic> getAllPlayerMatchStatistics() {
        return playerMatchStatisticRepository.findAll();
    }

    public Optional<PlayerMatchStatistic> getPlayerMatchStatisticById(Long id) {
        return playerMatchStatisticRepository.findById(id);
    }

    public PlayerMatchStatistic updatePlayerMatchStatistic(Long id, PlayerMatchStatistic updatedStatistic) {
        return playerMatchStatisticRepository.findById(id)
                .map(statistic -> {
                    statistic.setPlayer(updatedStatistic.getPlayer());
                    statistic.setMatch(updatedStatistic.getMatch());
                    statistic.setGoalsScored(updatedStatistic.getGoalsScored());
                    statistic.setAssists(updatedStatistic.getAssists());
                    statistic.setYellowCards(updatedStatistic.getYellowCards());
                    statistic.setRedCards(updatedStatistic.getRedCards());
                    statistic.setShotsOnTarget(updatedStatistic.getShotsOnTarget());
                    statistic.setShotsOffTarget(updatedStatistic.getShotsOffTarget());
                    statistic.setPassesCompleted(updatedStatistic.getPassesCompleted());
                    statistic.setPassesAttempted(updatedStatistic.getPassesAttempted());
                    statistic.setFoulsCommitted(updatedStatistic.getFoulsCommitted());
                    statistic.setFoulsSuffered(updatedStatistic.getFoulsSuffered());
                    statistic.setRating(updatedStatistic.getRating());
                    return playerMatchStatisticRepository.save(statistic);
                })
                .orElseThrow(() -> new RuntimeException("Estatística de jogador na partida não encontrada com id: " + id));
    }

    public void deletePlayerMatchStatistic(Long id) {
        playerMatchStatisticRepository.deleteById(id);
    }

    public List<PlayerStatsSummaryDTO> getPlayerStatsSummary() {
        List<Player> players = playerRepository.findAll();
        List<PlayerStatsSummaryDTO> summaryList = new ArrayList<>();
        for (Player player : players) {
            List<PlayerMatchStatistic> stats = playerMatchStatisticRepository.findByPlayer(player);
            PlayerStatsSummaryDTO dto = new PlayerStatsSummaryDTO();
            dto.setPlayerId(player.getId());
            dto.setPlayerName(player.getName());
            dto.setTeamName(player.getTeam() != null ? player.getTeam().getName() : "");
            dto.setTotalGoals(player.getGoals() + stats.stream().mapToInt(PlayerMatchStatistic::getGoalsScored).sum());
            dto.setTotalAssists(player.getAssists() + stats.stream().mapToInt(PlayerMatchStatistic::getAssists).sum());
            dto.setTotalYellowCards(stats.stream().mapToInt(PlayerMatchStatistic::getYellowCards).sum());
            dto.setTotalRedCards(stats.stream().mapToInt(PlayerMatchStatistic::getRedCards).sum());
            dto.setTotalShotsOnTarget(stats.stream().mapToInt(PlayerMatchStatistic::getShotsOnTarget).sum());
            dto.setTotalShotsOffTarget(stats.stream().mapToInt(PlayerMatchStatistic::getShotsOffTarget).sum());
            dto.setTotalPassesCompleted(stats.stream().mapToInt(PlayerMatchStatistic::getPassesCompleted).sum());
            dto.setTotalPassesAttempted(stats.stream().mapToInt(PlayerMatchStatistic::getPassesAttempted).sum());
            dto.setTotalFoulsCommitted(stats.stream().mapToInt(PlayerMatchStatistic::getFoulsCommitted).sum());
            dto.setTotalFoulsSuffered(stats.stream().mapToInt(PlayerMatchStatistic::getFoulsSuffered).sum());
            summaryList.add(dto);
        }
        return summaryList;
    }
} 