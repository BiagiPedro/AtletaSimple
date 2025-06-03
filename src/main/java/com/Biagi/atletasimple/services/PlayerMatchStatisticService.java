package com.Biagi.atletasimple.services;

import com.Biagi.atletasimple.models.PlayerMatchStatistic;
import com.Biagi.atletasimple.repositories.PlayerMatchStatisticRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerMatchStatisticService {

    private final PlayerMatchStatisticRepository playerMatchStatisticRepository;

    public PlayerMatchStatisticService(PlayerMatchStatisticRepository playerMatchStatisticRepository) {
        this.playerMatchStatisticRepository = playerMatchStatisticRepository;
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
} 