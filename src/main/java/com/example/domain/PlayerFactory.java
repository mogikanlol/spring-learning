package com.example.domain;

public final class PlayerFactory {

    private PlayerFactory() {
    }

    public static Player createPlayer() {
        return new Player("Player from Factory");
    }

}
