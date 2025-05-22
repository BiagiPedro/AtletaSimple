package com.Biagi.atletasimple.services;

import com.Biagi.atletasimple.models.Team;
import com.Biagi.atletasimple.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
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
        teamRepository.deleteById(id);
    }
}
