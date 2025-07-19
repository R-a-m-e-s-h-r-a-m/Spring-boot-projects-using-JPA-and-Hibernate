package com.example.player.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.player.model.Player;
import com.example.player.service.PlayerJpaService;

@RestController
public class PlayerController {
    @Autowired
    public PlayerJpaService service;

    @GetMapping("/players")
    public ArrayList<Player> getPlayers() {
        return service.getPlayerTeam();
    }

    @GetMapping("/players/{playerId}")
    public Player getPlayerById(@PathVariable("playerId") int playerId) {
        return service.getPlayerById(playerId);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player) {
        return service.addPlayer(player);
    }

    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@PathVariable("playerId") int playerId, @RequestBody Player player) {
        return service.updatePlayerById(playerId, player);
    }

    @DeleteMapping("/players/{playerId}")
    public void deletePlayer(@PathVariable("playerId") int playerId) {
        service.deletePlayer(playerId);
    }
}
