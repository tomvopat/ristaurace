// Tomáš Vopat - vopattom

package ristaurace.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Stul", schema = "public", catalog = "ristaurace")
public class StulEntity {
    private String cisloStolu;
    private BigDecimal pocetMist;
    private long stulId;
    private Collection<RStulRezervaceEntity> rStulRezervacesByStulId;
    private Collection<RUcetStulEntity> rUcetStulsByStulId;

    @Basic
    @Column(name = "Cislo_stolu")
    public String getCisloStolu() {
        return cisloStolu;
    }

    public void setCisloStolu(String cisloStolu) {
        this.cisloStolu = cisloStolu;
    }

    @Basic
    @Column(name = "Pocet_mist")
    public BigDecimal getPocetMist() {
        return pocetMist;
    }

    public void setPocetMist(BigDecimal pocetMist) {
        this.pocetMist = pocetMist;
    }

    @Id
    @Column(name = "StulID")
    public long getStulId() {
        return stulId;
    }

    public void setStulId(long stulId) {
        this.stulId = stulId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StulEntity that = (StulEntity) o;
        return stulId == that.stulId &&
                Objects.equals(cisloStolu, that.cisloStolu) &&
                Objects.equals(pocetMist, that.pocetMist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cisloStolu, pocetMist, stulId);
    }

    @OneToMany(mappedBy = "stulByStulId")
    public Collection<RStulRezervaceEntity> getrStulRezervacesByStulId() {
        return rStulRezervacesByStulId;
    }

    public void setrStulRezervacesByStulId(Collection<RStulRezervaceEntity> rStulRezervacesByStulId) {
        this.rStulRezervacesByStulId = rStulRezervacesByStulId;
    }

    @OneToMany(mappedBy = "stulByStulId")
    public Collection<RUcetStulEntity> getrUcetStulsByStulId() {
        return rUcetStulsByStulId;
    }

    public void setrUcetStulsByStulId(Collection<RUcetStulEntity> rUcetStulsByStulId) {
        this.rUcetStulsByStulId = rUcetStulsByStulId;
    }
}
