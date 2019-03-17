package com.example.persistence;

import com.example.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepositoryJpa extends JpaRepository<Player, Long>, PlayerRepository {

    Player findByName(String name);

    default void create(Player player) {
        this.save(player);
    }
}
