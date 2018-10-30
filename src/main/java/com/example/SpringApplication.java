package com.example;

import com.example.config.ApplicationConfig;
import com.example.domain.Player;
import com.example.service.PlayerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        Player player = ctx.getBean("player", Player.class);
        Player factoryPlayer = ctx.getBean("factoryPlayer", Player.class);

        System.out.println(player);
        System.out.println(factoryPlayer);

        PlayerService playerService = ctx.getBean("playerService", PlayerService.class);

        playerService.createPlayer(player);
        System.out.println(playerService.getPlayer(player.getName()));
        playerService.deletePlayer(player);
    }
}
