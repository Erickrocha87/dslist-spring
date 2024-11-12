package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.GameList;

public class GameListDto {

    private Long id;
    private String name;

    public GameListDto(){

    }

    public GameListDto(GameList entity) { //fazendo isso pro construtor não receber os campos separados e sem a entity
        id = entity.getId();
        name = entity.getName();
        
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    
}
