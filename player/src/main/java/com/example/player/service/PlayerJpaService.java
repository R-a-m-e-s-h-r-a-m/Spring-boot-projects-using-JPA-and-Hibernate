package com.example.player.service;

import java.util.ArrayList;
import com.example.player.model.Player;
import com.example.player.repository.PlayerJpaRepository;
import com.example.player.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PlayerJpaService implements PlayerRepository {

    @Autowired
    private PlayerJpaRepository playerJpaRepository;

    @Override
    public ArrayList<Player> getPlayerTeam() {
        return new ArrayList<>(playerJpaRepository.findAll());
    }

    @Override
    public Player getPlayerById(int playerId) {
        try {
            Player player = playerJpaRepository.findById(playerId).get();
            return player;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Player addPlayer(Player player) {
        playerJpaRepository.save(player);
        return player;
    }

    @Override
    public Player updatePlayerById(int playerId, Player player) {
        try {
            Player newPlayer = playerJpaRepository.findById(playerId).get();
            if (newPlayer.getPlayerName() != null) {
                newPlayer.setPlayerName(player.getPlayerName());
            }
            if (newPlayer.getJerseyNumber() != 0) {
                newPlayer.setJerseyNumber(player.getJerseyNumber());
            }
            if (newPlayer.getRole() != null) {
                newPlayer.setRole(player.getRole());
            }
            return playerJpaRepository.save(newPlayer);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deletePlayer(int playerId) {
        try {
            playerJpaRepository.deleteById(playerId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
