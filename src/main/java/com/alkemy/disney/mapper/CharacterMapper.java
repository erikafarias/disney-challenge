package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.entity.CharacterEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterMapper {

    public CharacterEntity characterDTO2Entity(CharacterDTO dto){
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setId(dto.getId());
        characterEntity.setName(dto.getName());
        characterEntity.setAge(dto.getAge());
        characterEntity.setWeight(dto.getWeight());
        characterEntity.setHistory(dto.getHistory());
        return characterEntity;
    }

    public CharacterDTO characterEntity2DTO(CharacterEntity entity){
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setId(entity.getId());
        characterDTO.setName(entity.getName());
        characterDTO.setAge(entity.getAge());
        characterDTO.setWeight(entity.getWeight());
        characterDTO.setHistory(entity.getHistory());
        return characterDTO;
    }

    public List<CharacterDTO> characterEntityList2DTOList(List<CharacterEntity> characters) {
        List<CharacterDTO> charactersDTOS = new ArrayList<>();
        for (CharacterEntity character : characters){
            charactersDTOS.add(characterEntity2DTO(character));
        }
        return charactersDTOS;
    }
}
