package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.MovieListDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.MovieEntity;
import com.alkemy.disney.repository.MovieRepository;
import com.alkemy.disney.service.MovieService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterMapper {

    public CharacterEntity characterDTO2Entity(CharacterDTO dto){
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setImage(dto.getImage());
        characterEntity.setId(dto.getId());
        characterEntity.setName(dto.getName());
        characterEntity.setAge(dto.getAge());
        characterEntity.setWeight(dto.getWeight());
        characterEntity.setHistory(dto.getHistory());
        characterEntity.setMovies(dto.getMovies());
        return characterEntity;
    }

    public CharacterDTO characterEntity2DTO(CharacterEntity entity){
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setImage(entity.getImage());
        characterDTO.setId(entity.getId());
        characterDTO.setName(entity.getName());
        characterDTO.setAge(entity.getAge());
        characterDTO.setWeight(entity.getWeight());
        characterDTO.setHistory(entity.getHistory());
        characterDTO.setMovies(entity.getMovies());

        return characterDTO;
    }

    public List<CharacterDTO> characterEntityList2DTOList(List<CharacterEntity> characters) {
        List<CharacterDTO> charactersDTOS = new ArrayList<>();
        for (CharacterEntity character : characters){
            charactersDTOS.add(characterEntity2DTO(character));
        }
        return charactersDTOS;
    }

   public CharacterEntity characterUpdateMapper(CharacterDTO character, CharacterEntity characterToUpdate){
      characterToUpdate.setImage(character.getImage());
       characterToUpdate.setName(character.getName());
       characterToUpdate.setAge(character.getAge());
       characterToUpdate.setHistory(character.getHistory());
       characterToUpdate.setWeight(character.getWeight());
       characterToUpdate.setMovies(character.getMovies());

       return characterToUpdate;
   }

}
