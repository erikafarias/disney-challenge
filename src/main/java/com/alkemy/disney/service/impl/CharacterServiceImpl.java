package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.mapper.CharacterMapper;
import com.alkemy.disney.repository.CharacterRepository;
import com.alkemy.disney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterMapper characterMapper;

    @Autowired
    private CharacterRepository characterRepository;

    public CharacterDTO save(CharacterDTO dto) {
        System.out.println("Convertir Personaje de DTO a Entity");
        CharacterEntity characterEntity = characterMapper.characterDTO2Entity(dto);
        System.out.println("Guardar Personaje");
        CharacterEntity characterEntitySaved = characterRepository.save(characterEntity);
        System.out.println("Convertir Personaje de Entity a DTO");
        CharacterDTO result = characterMapper.characterEntity2DTO(characterEntitySaved);
        System.out.println("Devolver Resultado: " + result.toString());
        return result;
    }
}
