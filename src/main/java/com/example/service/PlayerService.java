package com.example.service;

import com.example.domain.Player;

public interface PlayerService {

    void createPlayer(Player player);

    Player getPlayer(String name);

    void deletePlayer(Player player);

    void testTransaction();
}
