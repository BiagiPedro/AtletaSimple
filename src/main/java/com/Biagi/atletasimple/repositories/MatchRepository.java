package com.Biagi.atletasimple.repositories;

import com.Biagi.atletasimple.models.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
} 