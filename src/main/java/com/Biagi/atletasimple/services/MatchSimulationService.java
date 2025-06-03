package com.Biagi.atletasimple.services;

import com.Biagi.atletasimple.models.Match;
import com.Biagi.atletasimple.models.Player;
import com.Biagi.atletasimple.models.PlayerMatchStatistic;
import com.Biagi.atletasimple.models.Team;
import com.Biagi.atletasimple.repositories.MatchRepository;
import com.Biagi.atletasimple.repositories.TeamRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class MatchSimulationService {
    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;
    private final PlayerMatchStatisticService playerMatchStatisticService;
    private final Random random = new Random();

    public MatchSimulationService(
        TeamRepository teamRepository,
        MatchRepository matchRepository,
        PlayerMatchStatisticService playerMatchStatisticService
    ) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
        this.playerMatchStatisticService = playerMatchStatisticService;
    }

    public Match simulateRandomMatch() {
        List<Team> teams = teamRepository.findAll();
        if (teams.size() < 2) throw new RuntimeException("É necessário pelo menos dois times.");

        Collections.shuffle(teams);
        Team home = teams.get(0);
        Team away = teams.get(1);

        int homeScore = random.nextInt(6); // 0-5
        int awayScore = random.nextInt(6);

        Match match = new Match();
        match.setHomeTeam(home);
        match.setAwayTeam(away);
        match.setMatchDate(LocalDateTime.now());
        match.setHomeScore(homeScore);
        match.setAwayScore(awayScore);
        match.setStadium(home.getStadiumName());
        match.setCompetition("Amistoso");

        match = matchRepository.save(match);

        // Distribuir gols para jogadores do time da casa
        List<Player> homePlayers = home.getPlayers();
        int[] homeGoals = new int[homePlayers.size()];
        for (int i = 0; i < homeScore; i++) {
            int idx = random.nextInt(homePlayers.size());
            homeGoals[idx]++;
        }
        for (int i = 0; i < homePlayers.size(); i++) {
            playerMatchStatisticService.savePlayerMatchStatistic(generateStatsWithGoals(homePlayers.get(i), match, homeGoals[i]));
        }

        // Distribuir gols para jogadores do time visitante
        List<Player> awayPlayers = away.getPlayers();
        int[] awayGoals = new int[awayPlayers.size()];
        for (int i = 0; i < awayScore; i++) {
            int idx = random.nextInt(awayPlayers.size());
            awayGoals[idx]++;
        }
        for (int i = 0; i < awayPlayers.size(); i++) {
            playerMatchStatisticService.savePlayerMatchStatistic(generateStatsWithGoals(awayPlayers.get(i), match, awayGoals[i]));
        }

        return match;
    }

    public Match simulateMatchByTeams(Long homeTeamId, Long awayTeamId) {
        if (homeTeamId.equals(awayTeamId)) {
            throw new IllegalArgumentException("Os times devem ser diferentes.");
        }
        Team home = teamRepository.findById(homeTeamId).orElseThrow(() -> new RuntimeException("Time casa não encontrado"));
        Team away = teamRepository.findById(awayTeamId).orElseThrow(() -> new RuntimeException("Time visitante não encontrado"));
        int homeScore = random.nextInt(6);
        int awayScore = random.nextInt(6);
        Match match = new Match();
        match.setHomeTeam(home);
        match.setAwayTeam(away);
        match.setMatchDate(LocalDateTime.now());
        match.setHomeScore(homeScore);
        match.setAwayScore(awayScore);
        match.setStadium(home.getStadiumName());
        match.setCompetition("Amistoso");
        match = matchRepository.save(match);
        // Distribuir gols para jogadores do time da casa
        List<Player> homePlayers = home.getPlayers();
        int[] homeGoals = new int[homePlayers.size()];
        for (int i = 0; i < homeScore; i++) {
            int idx = random.nextInt(homePlayers.size());
            homeGoals[idx]++;
        }
        for (int i = 0; i < homePlayers.size(); i++) {
            playerMatchStatisticService.savePlayerMatchStatistic(generateStatsWithGoals(homePlayers.get(i), match, homeGoals[i]));
        }
        // Distribuir gols para jogadores do time visitante
        List<Player> awayPlayers = away.getPlayers();
        int[] awayGoals = new int[awayPlayers.size()];
        for (int i = 0; i < awayScore; i++) {
            int idx = random.nextInt(awayPlayers.size());
            awayGoals[idx]++;
        }
        for (int i = 0; i < awayPlayers.size(); i++) {
            playerMatchStatisticService.savePlayerMatchStatistic(generateStatsWithGoals(awayPlayers.get(i), match, awayGoals[i]));
        }
        return match;
    }

    private PlayerMatchStatistic generateStatsWithGoals(Player player, Match match, int goals) {
        PlayerMatchStatistic stats = new PlayerMatchStatistic();
        stats.setPlayer(player);
        stats.setMatch(match);
        stats.setGoalsScored(goals);
        stats.setAssists(random.nextInt(3));
        stats.setYellowCards(random.nextInt(2));
        stats.setRedCards(random.nextInt(2) == 1 ? 1 : 0);
        stats.setShotsOnTarget(random.nextInt(5));
        stats.setShotsOffTarget(random.nextInt(5));
        stats.setPassesCompleted(random.nextInt(30));
        stats.setPassesAttempted(stats.getPassesCompleted() + random.nextInt(10));
        stats.setFoulsCommitted(random.nextInt(4));
        stats.setFoulsSuffered(random.nextInt(4));
        stats.setRating(5.0 + random.nextDouble() * 5.0); // 5.0 a 10.0
        return stats;
    }
}
