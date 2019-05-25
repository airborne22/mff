package com.airborne.mff.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="obelisk")
public class Obelisk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="obelisk_id")
    private Integer obeliskId;

    @Column(name="obelisk_uuid")
    private String obeliskUuid;

    @Column(name="ctp_name")
    private String ctpName;

    @Column(name="obelisk_hash")
    private String obeliskHash;

    @Column(name="stat1")
    private String stat1;

    @Column(name="stat2")
    private String stat2;

    @Column(name="stat3")
    private String stat3;

    @Column(name="stat4")
    private String stat4;

    public Integer getObeliskId() {
        return obeliskId;
    }

    public void setObeliskId(Integer obeliskId) {
        this.obeliskId = obeliskId;
    }

    public String getObeliskUuid() {
        return obeliskUuid;
    }

    public void setObeliskUuid(String obeliskUuid) {
        this.obeliskUuid = obeliskUuid;
    }

    public String getCtpName() {
        return ctpName;
    }

    public void setCtpName(String ctpName) {
        this.ctpName = ctpName;
    }

    public String getObeliskHash() {
        return obeliskHash;
    }

    public void setObeliskHash(String obeliskHash) {
        this.obeliskHash = obeliskHash;
    }

    public String getStat1() {
        return stat1;
    }

    public void setStat1(String stat1) {
        this.stat1 = stat1;
    }

    public String getStat2() {
        return stat2;
    }

    public void setStat2(String stat2) {
        this.stat2 = stat2;
    }

    public String getStat3() {
        return stat3;
    }

    public void setStat3(String stat3) {
        this.stat3 = stat3;
    }

    public String getStat4() {
        return stat4;
    }

    public void setStat4(String stat4) {
        this.stat4 = stat4;
    }
}
