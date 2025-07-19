package com.example.player.repository;

import com.example.player.model.Player;
import java.util.ArrayList;

public interface PlayerRepository {
    ArrayList<Player> getPlayerTeam();

    Player getPlayerById(int playerId);

    Player addPlayer(Player player);

    Player updatePlayerById(int playerId, Player player);

    void deletePlayer(int playerId);
}
