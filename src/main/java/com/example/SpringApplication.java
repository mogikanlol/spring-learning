package com.example;

import com.example.domain.Player;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new GenericGroovyApplicationContext("ctx.groovy");

        Player player = ctx.getBean("player", Player.class);
        Player factoryPlayer = ctx.getBean("playerFactory", Player.class);

        System.out.println(player);
        System.out.println(factoryPlayer);
    }
}
