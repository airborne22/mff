package com.airborne.mff.importer.model;

import com.opencsv.bean.CsvBindByName;

public class CharacterData {

    @CsvBindByName
    String name;

    @CsvBindByName
    String type;

    @CsvBindByName
    boolean isNative;

    @CsvBindByName
    boolean hasReflect;

    @CsvBindByName
    boolean hasDebuff;

    @CsvBindByName
    String characterUuid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isNative() {
        return isNative;
    }

    public void setNative(boolean aNative) {
        isNative = aNative;
    }

    public boolean isHasReflect() {
        return hasReflect;
    }

    public void setHasReflect(boolean hasReflect) {
        this.hasReflect = hasReflect;
    }

    public boolean isHasDebuff() {
        return hasDebuff;
    }

    public void setHasDebuff(boolean hasDebuff) {
        this.hasDebuff = hasDebuff;
    }

    public String getCharacterUuid() {
        return characterUuid;
    }

    public void setCharacterUuid(String characterUuid) {
        this.characterUuid = characterUuid;
    }
}