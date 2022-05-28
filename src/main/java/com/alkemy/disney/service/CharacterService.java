package com.alkemy.disney.service;

import com.alkemy.disney.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {

    CharacterDTO save(CharacterDTO dto);

    List<CharacterDTO> getAllCharacters();

    CharacterDTO getCharacterDetailsByID(Long id);

    CharacterDTO update(Long id, CharacterDTO character);
}
