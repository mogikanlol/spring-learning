package com.example.config;

import com.example.domain.Player;
import com.example.domain.PlayerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerConfig {
    @Bean
    public Player player() {
        return new Player("Player");
    }

    @Bean
    public Player factoryPlayer() {
        return PlayerFactory.createPlayer();
    }

}
