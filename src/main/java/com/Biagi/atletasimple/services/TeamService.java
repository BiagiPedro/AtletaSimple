package com.Biagi.atletasimple.services;

import com.Biagi.atletasimple.models.Team;
import com.Biagi.atletasimple.repositories.TeamRepository;
import com.Biagi.atletasimple.repositories.PlayerRepository;
import com.Biagi.atletasimple.repositories.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final MatchRepository matchRepository;

    public TeamService(TeamRepository teamRepository, PlayerRepository playerRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.matchRepository = matchRepository;
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    public Team updateTeam(Long id, Team updatedTeam) {
        return teamRepository.findById(id)
                .map(team -> {
                    team.setName(updatedTeam.getName());
                    team.setCity(updatedTeam.getCity());
                    return teamRepository.save(team);
                })
                .orElseThrow(() -> new RuntimeException("Time não encontrado com id: " + id));
    }

    public void deleteTeam(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new RuntimeException("Time não encontrado"));
        // Deletar todas as partidas onde o time é home ou away
        matchRepository.findByHomeTeam(team).forEach(match -> matchRepository.deleteById(match.getId()));
        matchRepository.findByAwayTeam(team).forEach(match -> matchRepository.deleteById(match.getId()));
        teamRepository.deleteById(id);
    }
}
