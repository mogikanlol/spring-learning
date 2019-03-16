package com.example.service;

import com.example.domain.Player;
import com.example.persistence.PlayerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public void testTransaction() {
        String name = "transcational";
        logger.info("Check that player does not exist. Expect null, but actual is = {}", String.valueOf(playerMapper.findByName(name)));

        Player player = new Player();
        player.setName(name);
        player.setLevel(100500);

        this.createPlayer(player);

        this.getPlayer(name);

        throw new RuntimeException();
    }
}
