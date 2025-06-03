package com.Biagi.atletasimple.services;

import com.Biagi.atletasimple.models.Match;
import com.Biagi.atletasimple.repositories.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Optional<Match> getMatchById(Long id) {
        return matchRepository.findById(id);
    }

    public Match updateMatch(Long id, Match updatedMatch) {
        return matchRepository.findById(id)
                .map(match -> {
                    match.setHomeTeam(updatedMatch.getHomeTeam());
                    match.setAwayTeam(updatedMatch.getAwayTeam());
                    match.setMatchDate(updatedMatch.getMatchDate());
                    match.setHomeScore(updatedMatch.getHomeScore());
                    match.setAwayScore(updatedMatch.getAwayScore());
                    match.setStadium(updatedMatch.getStadium());
                    match.setCompetition(updatedMatch.getCompetition());
                    return matchRepository.save(match);
                })
                .orElseThrow(() -> new RuntimeException("Partida não encontrada com id: " + id));
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
} 