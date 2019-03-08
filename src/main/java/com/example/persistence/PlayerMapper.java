package com.example.persistence;

import com.example.domain.Player;

public interface PlayerMapper {

    void create(Player player);

    void delete(Player player);

    Player findByName(String name);

}
