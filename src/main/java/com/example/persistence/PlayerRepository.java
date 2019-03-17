package com.example.persistence;

import com.example.domain.Player;

public interface PlayerRepository {

    void create(Player player);

    void delete(Player player);

    Player findByName(String name);

}
