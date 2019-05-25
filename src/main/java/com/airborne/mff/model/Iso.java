package com.airborne.mff.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="iso")
public class Iso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="iso_id")
    private Integer isoId;

    @Column(name="iso_uuid")
    private String isoUuid;

    @Column(name="name", nullable = false, unique = true)
    private String name;

    @Column(name="stat")
    private String stat;

    @ManyToMany(mappedBy = "isos")
    Set<IsoSet> isoSets;

    public Integer getIsoId() {
        return isoId;
    }

    public void setIsoId(Integer isoId) {
        this.isoId = isoId;
    }

    public String getIsoUuid() {
        return isoUuid;
    }

    public void setIsoUuid(String isoUuid) {
        this.isoUuid = isoUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
