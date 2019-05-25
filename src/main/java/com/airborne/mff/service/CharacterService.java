package com.airborne.mff.service;

import com.airborne.mff.model.Character;
import com.airborne.mff.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    @Autowired
    CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public String addCharacter(Character character) {
        Character result = characterRepository.save(character);
        return result.getName();
    }

    public int addCharacters(List<Character> characters) {
        int count = 0;
        Iterator<Character> iterator = characterRepository.saveAll(characters).iterator();
        while(iterator.hasNext()) {
            count++;
            iterator.next();
        }
        return count;
    }

    public Character getByName(String name) {
        Objects.requireNonNull(name);
        name = name.toLowerCase();
        return characterRepository.getByName(name).orElse(null);
    }
}
