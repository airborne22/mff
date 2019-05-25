package com.airborne.mff.importer;

import com.airborne.mff.importer.model.CharacterData;
import com.airborne.mff.model.Character;
import com.airborne.mff.service.CharacterService;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterImporter {

    private static final Logger logger = LogManager.getLogger();

    @Value("${import.data:false}")
    boolean importData;

    @Autowired
    CharacterService characterService;

    @PostConstruct
    public void run() throws Exception {
        if (importData) {
            importCharacters();
        }
    }

    public void importCharacters() throws Exception {
        logger.info("Importing Character Data");
        List<Character> characters = new ArrayList<>();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("csv/characters.csv");
             CSVReader csvReader = new CSVReader(new BufferedReader(new InputStreamReader(inputStream)))) {

            List<CharacterData> characterDataList = new CsvToBeanBuilder<CharacterData>(csvReader)
                    .withType(CharacterData.class)
                    .build()
                    .parse();

            for(CharacterData characterData : characterDataList) {
                Character character = new Character(characterData);
                logger.info(character.getName() + " " + character.getCharacterUuid() + " " + character.getType());
                characters.add(character);
            }
        }
        if (CollectionUtils.isNotEmpty(characters)) {
            int count = characterService.addCharacters(characters);
            logger.info("Saved {} characters", count);
        } else {
            logger.info("Found 0 characters");
        }
    }
}
