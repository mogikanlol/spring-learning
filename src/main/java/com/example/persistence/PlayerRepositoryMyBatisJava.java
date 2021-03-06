package com.example.persistence;


import com.example.domain.Player;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Primary;

@Mapper
@Primary
public interface PlayerRepositoryMyBatisJava extends PlayerRepository {

    @Insert("INSERT INTO PLAYERS (NAME, LEVEL) VALUES (#{name}, #{level})")
    void create(Player player);

    @Select("SELECT * FROM PLAYERS WHERE NAME = #{name}")
    Player findByName(String name);

    @Delete("DELETE FROM PLAYERS WHERE NAME = #{name}")
    void delete(Player player);
}
