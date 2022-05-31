package com.alkemy.disney.controller;

import com.alkemy.disney.dto.CharacterDTO;
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

    @PostMapping("/create")
    public ResponseEntity<CharacterDTO> save(@Valid @RequestBody CharacterDTO character) {
        CharacterDTO savedCharacter = characterService.save(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCharacter);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CharacterDTO>> getAll() {
        List<CharacterDTO> characters = characterService.getAllCharacters();
        return ResponseEntity.ok().body(characters);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CharacterDTO> getCharacterDetailsByID(@PathVariable Long id){
        CharacterDTO character = characterService.getCharacterDetailsByID(id);
        return ResponseEntity.ok(character);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<CharacterDTO> update(@PathVariable Long id,@Valid @RequestBody CharacterDTO character){
        CharacterDTO updatedCharacter = characterService.update(id,character);
        return ResponseEntity.ok().body(updatedCharacter);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<CharacterDTO> delete(@PathVariable Long id){
        CharacterDTO deletedCharacter = characterService.delete(id);
        return ResponseEntity.ok(deletedCharacter);
    }
}
