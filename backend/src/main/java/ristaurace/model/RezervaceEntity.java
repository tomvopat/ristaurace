// Tomáš Vopat - vopattom

package ristaurace.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Rezervace", schema = "public", catalog = "ristaurace")
public class RezervaceEntity {
    private Timestamp casZahajeni;
    private Timestamp casUkonceni;
    private String jmeno;
    private Long pocetOsob;
    private long rezervaceId;
    private Collection<RStulRezervaceEntity> rStulRezervacesByRezervaceId;

    @Basic
    @Column(name = "Cas_zahajeni")
    public Timestamp getCasZahajeni() {
        return casZahajeni;
    }

    public void setCasZahajeni(Timestamp casZahajeni) {
        this.casZahajeni = casZahajeni;
    }

    @Basic
    @Column(name = "Cas_ukonceni")
    public Timestamp getCasUkonceni() {
        return casUkonceni;
    }

    public void setCasUkonceni(Timestamp casUkonceni) {
        this.casUkonceni = casUkonceni;
    }

    @Basic
    @Column(name = "Jmeno")
    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    @Basic
    @Column(name = "Pocet_osob")
    public Long getPocetOsob() {
        return pocetOsob;
    }

    public void setPocetOsob(Long pocetOsob) {
        this.pocetOsob = pocetOsob;
    }

    @Id
    @Column(name = "RezervaceID")
    public long getRezervaceId() {
        return rezervaceId;
    }

    public void setRezervaceId(long rezervaceId) {
        this.rezervaceId = rezervaceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RezervaceEntity that = (RezervaceEntity) o;
        return rezervaceId == that.rezervaceId &&
                Objects.equals(casZahajeni, that.casZahajeni) &&
                Objects.equals(casUkonceni, that.casUkonceni) &&
                Objects.equals(jmeno, that.jmeno) &&
                Objects.equals(pocetOsob, that.pocetOsob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(casZahajeni, casUkonceni, jmeno, pocetOsob, rezervaceId);
    }

    @OneToMany(mappedBy = "rezervaceByRezervaceId")
    public Collection<RStulRezervaceEntity> getrStulRezervacesByRezervaceId() {
        return rStulRezervacesByRezervaceId;
    }

    public void setrStulRezervacesByRezervaceId(Collection<RStulRezervaceEntity> rStulRezervacesByRezervaceId) {
        this.rStulRezervacesByRezervaceId = rStulRezervacesByRezervaceId;
    }
}
