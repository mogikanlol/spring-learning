package com.example.service;

import com.example.domain.Player;
import com.example.persistence.PlayerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static final Logger logger = LoggerFactory.getLogger(PlayerServiceImpl.class);

    private final PlayerMapper playerMapper;

    public PlayerServiceImpl(@Qualifier("playerMapperJava") PlayerMapper playerMapper) {
        this.playerMapper = playerMapper;
    }

    @Override
    public void createPlayer(Player player) {
        logger.info("Creating player = {}", player);
        playerMapper.create(player);
    }

    @Override
    public Player getPlayer(String name) {
        logger.info("Finding player by name = {}", name);
        return playerMapper.findByName(name);
    }

    @Override
    public void deletePlayer(Player player) {
        logger.info("Deleting player = {}", player);
        playerMapper.delete(player);
    }
}
