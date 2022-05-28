package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.mapper.CharacterMapper;
import com.alkemy.disney.repository.CharacterRepository;
import com.alkemy.disney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterMapper characterMapper;

    @Autowired
    private CharacterRepository characterRepository;

    public CharacterDTO save(CharacterDTO dto) {
        CharacterEntity characterEntity = characterMapper.characterDTO2Entity(dto);
        CharacterEntity characterEntitySaved = characterRepository.save(characterEntity);
        CharacterDTO result = characterMapper.characterEntity2DTO(characterEntitySaved);
        return result;
    }

    public List<CharacterDTO> getAllCharacters() {
        List<CharacterEntity> characters = characterRepository.findAll();
        List<CharacterDTO> result = characterMapper.characterEntityList2DTOList(characters);
        return result;
    }

    @Override
    public CharacterDTO getCharacterDetailsByID(Long id) {
        CharacterEntity character = characterRepository.getById(id);
        CharacterDTO result = characterMapper.characterEntity2DTO(character);
        return result;
    }
}
