package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDto;
import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projection.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

@Service //registrando como um componente do sistema
public class GameService {

    @Autowired //injetanto "instância" de game repository dentro de game service
    private GameRepository gameRepository;

    @Transactional(readOnly = true) //garante que a operação vai acontecer seguindo os padrões ACID, readOnly acessegura que não vai ser operação de escrita
    public GameDto findById(Long id){
        Game result = gameRepository.findById(id).get();
        GameDto dto = new GameDto(result); //convertendo game para dto
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findAll(){
        var result = gameRepository.findAll();  //o framework tem os métodos de acessos a dados/ pode ser usado var ou list
        List<GameMinDto> dto = result.stream().map(x -> new GameMinDto(x)).toList(); //usando steam para acessar a lista result to tipo game e trocar para game dto
        return dto; //ou podemos retornar direto com o stream
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findByList(Long listId){
        List<GameMinProjection
        > result = gameRepository.searchByList(listId);  //o framework tem os métodos de acessos a dados/ pode ser usado var ou list
        return result.stream().map(x -> new GameMinDto(x)).toList(); //usando steam para acessar a lista result to tipo game e trocar para game dto
        
    }
}
