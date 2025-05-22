package com.Biagi.atletasimple.repositories;

import com.Biagi.atletasimple.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
