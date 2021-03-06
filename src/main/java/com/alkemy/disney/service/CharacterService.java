package com.alkemy.disney.service;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.CharacterListDTO;

import java.util.List;

public interface CharacterService {

    CharacterDTO save(CharacterDTO dto);

    List<CharacterListDTO> getAllCharacters();

    CharacterDTO getCharacterDetailsByID(Long id);

    CharacterDTO update(Long id, CharacterDTO character);

    void delete(Long id);
}
