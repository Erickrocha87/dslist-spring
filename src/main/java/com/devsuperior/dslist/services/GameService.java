package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.repositories.GameRepository;

@Service //registrando como um componente do sistema
public class GameService {

    @Autowired //injetanto "instância" de game repository dentro de game service
    private GameRepository gameRepository;

    public List<GameMinDto> findAll(){

        var result = gameRepository.findAll();  //o framework tem os métodos de acessos a dados/ pode ser usado var ou list
        List<GameMinDto> dto = result.stream().map(x -> new GameMinDto(x)).toList(); //usando steam para acessar a lista result to tipo game e trocar para game dto
        return dto; //ou podemos retornar direto com o stream
    }

}
