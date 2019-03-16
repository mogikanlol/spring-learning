package com.example.domain;

public class Player {

    private Long id;

    private String name;

    @InjectRandomLevel(min = 1, max = 3)
    private int level;

    public Player() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public Player(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
