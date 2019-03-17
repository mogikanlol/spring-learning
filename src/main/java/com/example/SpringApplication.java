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

        PlayerService playerService = ctx.getBean(PlayerService.class);

        System.out.println("Player = " + player);
        System.out.println("Player from factory = " + factoryPlayer);

        playerService.createPlayer(player);

        System.out.println("Player from database = " + playerService.getPlayer(player.getName()));

        playerService.deletePlayer(player);

        testTransaction(playerService);

    }

    private static void testTransaction(PlayerService playerService) {
        System.out.println("---Testing Transaction---");

        try {
            playerService.testTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Expect the player is null, but actual is = " + playerService.getPlayer("transactional"));
        System.out.println("---Testing Transaction---");
    }
}
