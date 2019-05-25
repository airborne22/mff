package com.airborne.mff.controller;

import com.airborne.mff.exception.ObjectNotFoundException;
import com.airborne.mff.model.Character;
import com.airborne.mff.service.CharacterService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @PostMapping()
    public String addCharacter(@NotBlank Character character) {
        return characterService.addCharacter(character);
    }

    @GetMapping("/{name}")
    public Character getCharacterByName(@PathVariable String name) throws ObjectNotFoundException {
        return characterService.getByName(name);
    }

    @GetMapping(value = "/image", produces = {"image/jpeg", "image/png"})
    public @ResponseBody byte[] getImage() throws IOException {
        InputStream in = getClass().getResourceAsStream("/static/image/wolverine.png");
        return IOUtils.toByteArray(in);
    }
}