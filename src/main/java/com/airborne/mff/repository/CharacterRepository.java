package com.airborne.mff.repository;

import com.airborne.mff.model.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> {

    Optional<Character> getByName(String name);
}
