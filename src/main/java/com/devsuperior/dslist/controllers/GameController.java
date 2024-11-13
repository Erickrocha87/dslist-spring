package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameDto;
import com.devsuperior.dslist.dto.GameMinDto;

import com.devsuperior.dslist.services.GameService;
// o controlador implementa api "a interface do backend "

@RestController //registrando como um componente do sistema
@RequestMapping(value = "/games") //definindo como é o caminho da url
public class GameController {

    @Autowired //injeta o service e o service vai injetar o repository
    private GameService gameService;

    @GetMapping //definindo que o http é Get
    public List<GameMinDto> findAll(){
        List<GameMinDto> result = gameService.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public GameDto findById(@PathVariable Long id){ //garante que o id vai ser o correto
        GameDto result = gameService.findById(id);
       return result;
    }

}
