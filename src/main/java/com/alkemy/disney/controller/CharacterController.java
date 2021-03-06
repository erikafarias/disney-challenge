package com.alkemy.disney.controller;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.CharacterListDTO;
import com.alkemy.disney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @PostMapping
    public ResponseEntity<CharacterDTO> save(@Valid @RequestBody CharacterDTO character) {
        CharacterDTO savedCharacter = characterService.save(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCharacter);
    }

    @GetMapping
    public ResponseEntity<List<CharacterListDTO>> getAll() {
        List<CharacterListDTO> characters = characterService.getAllCharacters();
        return ResponseEntity.ok().body(characters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> getCharacterDetailsByID(@PathVariable Long id){
        CharacterDTO character = characterService.getCharacterDetailsByID(id);
        return ResponseEntity.ok(character);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterDTO> update(@PathVariable Long id,@Valid @RequestBody CharacterDTO character){
        CharacterDTO updatedCharacter = characterService.update(id,character);
        return ResponseEntity.ok().body(updatedCharacter);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        characterService.delete(id);
    }
}
