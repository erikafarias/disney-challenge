package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.mapper.CharacterMapper;
import com.alkemy.disney.repository.CharacterRepository;
import com.alkemy.disney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public CharacterDTO getCharacterDetailsByID(Long id) {
        Optional<CharacterEntity> character = characterRepository.findById(id);
        if (!character.isPresent()) {
            throw new RuntimeException("Character with id " + id + " not found");
        }
        CharacterDTO result = characterMapper.characterEntity2DTO(character.get());
        return result;
    }

    public CharacterDTO update(Long id, CharacterDTO character) {
        Optional<CharacterEntity> characterEntityToUpdate = characterRepository.findById(id);
        CharacterEntity characterToUpdate = characterEntityToUpdate.get();

        characterToUpdate.setName(character.getName());
        characterToUpdate.setAge(character.getAge());
        characterToUpdate.setHistory(character.getHistory());
        characterToUpdate.setWeight(character.getWeight());
        characterToUpdate.setMovies(character.getMovies());

        CharacterEntity characterEntityUpdated = characterRepository.save(characterToUpdate);

        CharacterDTO newCharacter = characterMapper.characterEntity2DTO(characterEntityUpdated);

        return newCharacter;

    }

    public void delete(Long id) {
        Optional<CharacterEntity> character = characterRepository.findById(id);
        if(!character.isPresent()){
            throw new RuntimeException("Character with id " + id + " not found");
        }
        characterRepository.deleteById(id);
    }


}
