package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> { //camada de acesso ao BD, nos parâmetros vai a entidade e o tipo do ID

}
