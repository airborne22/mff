package com.airborne.mff.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="iso_set")
public class IsoSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="iso_set_id")
    private Integer isoSetId;

    @Column(name="iso_set_uuid")
    private String isoSetUuid;

    @Column(name="name", nullable = false, unique = true)
    private String name;

    @Column(name="type")
    private String type;

    @Column(name="bonus_stat")
    private String bonusStat;

    @ManyToMany(mappedBy = "isoSets")
    Set<Character> characters;

    @ManyToMany
    @JoinTable(
            name = "iso_set_composition",
            joinColumns = @JoinColumn(name = "iso_set_id"),
            inverseJoinColumns = @JoinColumn(name = "iso_id"))
    Set<Iso> isos;

    public Integer getIsoSetId() {
        return isoSetId;
    }

    public void setIsoSetId(Integer isoSetId) {
        this.isoSetId = isoSetId;
    }

    public String getIsoSetUuid() {
        return isoSetUuid;
    }

    public void setIsoSetUuid(String isoSetUuid) {
        this.isoSetUuid = isoSetUuid;
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

    public String getBonusStat() {
        return bonusStat;
    }

    public void setBonusStat(String bonusStat) {
        this.bonusStat = bonusStat;
    }
}
