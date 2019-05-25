package com.airborne.mff.model;

import javax.persistence.*;

@Entity
@Table(name="character_obelisk")
public class CharacterObelisk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="character_obelisk_id")
    private Integer characterObeliskId;

    @Column(name="character_id")
    private Integer characterId;

    @Column(name="obelisk_id")
    private Integer obeliskId;

    @Column(name="type")
    private String type;

    public Integer getCharacterObeliskId() {
        return characterObeliskId;
    }

    public void setCharacterObeliskId(Integer characterObeliskId) {
        this.characterObeliskId = characterObeliskId;
    }

    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    public Integer getObeliskId() {
        return obeliskId;
    }

    public void setObeliskId(Integer obeliskId) {
        this.obeliskId = obeliskId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
