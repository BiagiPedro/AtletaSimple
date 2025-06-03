package com.Biagi.atletasimple.repositories;

import com.Biagi.atletasimple.models.Match;
import com.Biagi.atletasimple.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findByHomeTeam(Team team);
    List<Match> findByAwayTeam(Team team);
} 