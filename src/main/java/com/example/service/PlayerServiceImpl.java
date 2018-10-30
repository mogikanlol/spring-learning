package com.example.service;

import com.example.domain.Player;
import com.example.persistence.PlayerMapper;
import org.springframework.stereotype.Service;

@Service("playerService")
public class PlayerServiceImpl implements PlayerService {


    private final PlayerMapper playerMapper;

    public PlayerServiceImpl(PlayerMapper playerMapper) {
        this.playerMapper = playerMapper;
    }

    @Override
    public void createPlayer(Player player) {
        playerMapper.create(player);
    }

    @Override
    public Player getPlayer(String name) {
        return playerMapper.findByName(name);
    }

    @Override
    public void deletePlayer(Player player) {
        playerMapper.delete(player);
    }
}
