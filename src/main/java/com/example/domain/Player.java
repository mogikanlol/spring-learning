package com.example.domain;

public class Player {

    private final String name;

    @InjectRandomLevel(min = 1, max = 3)
    private int level;

    public Player(String name) {
        this.name = name;
        this.level = 0;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
