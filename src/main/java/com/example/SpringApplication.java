package com.example;

import com.example.domain.Player;
import com.example.service.PlayerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new GenericGroovyApplicationContext("ctx.groovy");

        Player player = ctx.getBean("player", Player.class);
        Player factoryPlayer = ctx.getBean("playerFactory", Player.class);

        System.out.println(player);
        System.out.println(factoryPlayer);

        PlayerService playerService = ctx.getBean("playerService", PlayerService.class);
        playerService.createPlayer(player);
        System.out.println(playerService.getPlayer(player.getName()));
        playerService.deletePlayer(player);
    }
}
