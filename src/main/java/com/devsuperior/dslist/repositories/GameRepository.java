package com.devsuperior.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projection.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long> { //camada de acesso ao BD, nos parâmetros vai a entidade e o tipo do ID

    //anotação para funcionar o sql na query
    @Query(nativeQuery = true, value = """
            SELECT tb_game.id, tb_game.title, tb_game.game_year AS year, tb_game.img_url AS imgUrl,
            tb_game.short_description AS shortDescription, tb_belonging.position
            FROM tb_game
            INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
            WHERE tb_belonging.game_list_id = :listId 
            ORDER BY tb_belonging.position
                """)
    List<GameMinProjection> searchByList(Long listId); //Parametro passo na query
    //Gamemin é uma interface
}
