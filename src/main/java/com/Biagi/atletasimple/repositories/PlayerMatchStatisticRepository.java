package com.Biagi.atletasimple.repositories;

import com.Biagi.atletasimple.models.PlayerMatchStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Biagi.atletasimple.models.Player;
import java.util.List;

public interface PlayerMatchStatisticRepository extends JpaRepository<PlayerMatchStatistic, Long> {
    List<PlayerMatchStatistic> findByPlayer(Player player);
} 