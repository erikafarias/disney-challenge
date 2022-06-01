package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.CharacterListDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.mapper.CharacterMapper;
import com.alkemy.disney.repository.CharacterRepository;
import com.alkemy.disney.service.CharacterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterMapper characterMapper;

    @Autowired
    private CharacterRepository characterRepository;

    ModelMapper modelMapper = new ModelMapper();

    public CharacterDTO save(CharacterDTO dto) {
        CharacterEntity characterEntity = characterMapper.characterDTO2Entity(dto);
        CharacterEntity characterEntitySaved = characterRepository.save(characterEntity);
        CharacterDTO result = characterMapper.characterEntity2DTO(characterEntitySaved);
        return result;
    }

    public List<CharacterListDTO> getAllCharacters() {
        List<CharacterEntity> characters = characterRepository.findAll();
        List<CharacterListDTO> result = new ArrayList<>();
        for (CharacterEntity c : characters) {
           CharacterListDTO cDTO = modelMapper.map(c, CharacterListDTO.class);
              result.add(cDTO);
        }

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
        if (!characterEntityToUpdate.isPresent()) {
            throw new RuntimeException("Character with id " + id + " not found");
        }
        CharacterEntity characterToUpdate = characterEntityToUpdate.get();
        CharacterEntity characterEntityUpdated = characterRepository.save(characterMapper.characterUpdateMapper(character, characterToUpdate));
        return characterMapper.characterEntity2DTO(characterEntityUpdated);
    }

    public void delete(Long id) {
        Optional<CharacterEntity> character = characterRepository.findById(id);
        if(!character.isPresent()){
            throw new RuntimeException("Character with id " + id + " not found");
        }
        characterRepository.deleteById(id);
    }


}
