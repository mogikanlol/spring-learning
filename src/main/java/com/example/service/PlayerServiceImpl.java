package com.example.service;

import com.example.domain.Player;
import com.example.persistence.PlayerMapper;

public class PlayerServiceImpl implements PlayerService {

    private final PlayerMapper playerMapper;

    public PlayerServiceImpl(PlayerMapper playerMapper) {
        this.playerMapper = playerMapper;
    }


    @Override
    public void createPlayer(Player player) {
        this.playerMapper.create(player);
    }

    @Override
    public Player getPlayer(String name) {
        return this.playerMapper.findByName(name);
    }

    @Override
    public void deletePlayer(Player player) {
        this.playerMapper.delete(player);
    }
}
