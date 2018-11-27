// Tomáš Vopat - vopattom

package ristaurace.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Ucet", schema = "public", catalog = "ristaurace")
public class UcetEntity {
    private Timestamp datumVytvoreni;
    private String mena;
    private String platbaKartou;
    private Float sleva;
    private long ucetId;
    private Collection<RUcetStulEntity> rUcetStulsByUcetId;
    private Collection<StavPolozkyEntity> stavPolozkiesByUcetId;

    @Basic
    @Column(name = "Datum_vytvoreni")
    public Timestamp getDatumVytvoreni() {
        return datumVytvoreni;
    }

    public void setDatumVytvoreni(Timestamp datumVytvoreni) {
        this.datumVytvoreni = datumVytvoreni;
    }

    @Basic
    @Column(name = "Mena")
    public String getMena() {
        return mena;
    }

    public void setMena(String mena) {
        this.mena = mena;
    }

    @Basic
    @Column(name = "Platba_kartou")
    public String getPlatbaKartou() {
        return platbaKartou;
    }

    public void setPlatbaKartou(String platbaKartou) {
        this.platbaKartou = platbaKartou;
    }

    @Basic
    @Column(name = "Sleva")
    public Float getSleva() {
        return sleva;
    }

    public void setSleva(Float sleva) {
        this.sleva = sleva;
    }

    @Id
    @Column(name = "UcetID")
    public long getUcetId() {
        return ucetId;
    }

    public void setUcetId(long ucetId) {
        this.ucetId = ucetId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UcetEntity that = (UcetEntity) o;
        return ucetId == that.ucetId &&
                Objects.equals(datumVytvoreni, that.datumVytvoreni) &&
                Objects.equals(mena, that.mena) &&
                Objects.equals(platbaKartou, that.platbaKartou) &&
                Objects.equals(sleva, that.sleva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datumVytvoreni, mena, platbaKartou, sleva, ucetId);
    }

    @OneToMany(mappedBy = "ucetByUcetId")
    public Collection<RUcetStulEntity> getrUcetStulsByUcetId() {
        return rUcetStulsByUcetId;
    }

    public void setrUcetStulsByUcetId(Collection<RUcetStulEntity> rUcetStulsByUcetId) {
        this.rUcetStulsByUcetId = rUcetStulsByUcetId;
    }

    @OneToMany(mappedBy = "ucetByUcetId")
    public Collection<StavPolozkyEntity> getStavPolozkiesByUcetId() {
        return stavPolozkiesByUcetId;
    }

    public void setStavPolozkiesByUcetId(Collection<StavPolozkyEntity> stavPolozkiesByUcetId) {
        this.stavPolozkiesByUcetId = stavPolozkiesByUcetId;
    }
}
