package com.Biagi.atletasimple.services;

import com.Biagi.atletasimple.models.Player;
import com.Biagi.atletasimple.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    public Player updatePlayer(Long id, Player updatedPlayer) {
        return playerRepository.findById(id)
                .map(player -> {
                    player.setName(updatedPlayer.getName());
                    player.setPosition(updatedPlayer.getPosition());
                    player.setTeam(updatedPlayer.getTeam());
                    return playerRepository.save(player);
                })
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado com id: " + id));
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
