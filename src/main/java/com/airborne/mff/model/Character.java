package com.airborne.mff.model;

import com.airborne.mff.importer.model.CharacterData;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="character")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="character_id")
    private Integer characterId;

    @Column(name="character_uuid")
    private String characterUuid;

    @Column(name="name", nullable = false, unique = true)
    private String name;

    @Column(name="type")
    private String type;

    @Column(name="leadership")
    private String leadership;

    @Column(name="t1_passive")
    private String t1Passive;

    @Column(name="t2_passive")
    private String t2Passive;

    @Column(name="t3_ability")
    private String t3Ability;

    @Column(name="is_support")
    private boolean isSupport;

    @Column(name="has_reflect")
    private boolean hasReflect;

    @Column(name="has_debuff")
    private boolean hasDebuff;

    @Column(name="is_native")
    private boolean isNative;

    @ManyToMany
    @JoinTable(
            name = "character_iso_set",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "iso_set_id"))
    private Set<IsoSet> isoSets;

    @ManyToMany
    @JoinTable(
            name = "character_image",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id"))
    private Set<Image> images;

    public Character() {
    }

    public Character(CharacterData characterData) {
        this.name = characterData.getName();
        this.characterUuid = characterData.getCharacterUuid();
        this.type = characterData.getType();
        this.hasDebuff = characterData.isHasDebuff();
        this.hasReflect = characterData.isHasReflect();
        this.isNative = characterData.isNative();
    }

    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    public String getCharacterUuid() {
        return characterUuid;
    }

    public void setCharacterUuid(String characterUuid) {
        this.characterUuid = characterUuid;
    }

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

    public String getLeadership() {
        return leadership;
    }

    public void setLeadership(String leadership) {
        this.leadership = leadership;
    }

    public String getT1Passive() {
        return t1Passive;
    }

    public void setT1Passive(String t1Passive) {
        this.t1Passive = t1Passive;
    }

    public String getT2Passive() {
        return t2Passive;
    }

    public void setT2Passive(String t2Passive) {
        this.t2Passive = t2Passive;
    }

    public String getT3Ability() {
        return t3Ability;
    }

    public void setT3Ability(String t3Ability) {
        this.t3Ability = t3Ability;
    }

    public boolean isSupport() {
        return isSupport;
    }

    public void setSupport(boolean support) {
        isSupport = support;
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

    public boolean isNative() {
        return isNative;
    }

    public void setNative(boolean isNative) {
        this.isNative = isNative;
    }

    public Set<IsoSet> getIsoSets() {
        return isoSets;
    }

    public void setIsoSets(Set<IsoSet> isoSets) {
        this.isoSets = isoSets;
    }
}
