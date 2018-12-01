// Tomáš Vopat - vopattom

package ristaurace.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ucet", schema = "public", catalog = "ristaurace")
public class UcetEntity {
    private int id;
    private Timestamp datumVytvoreni;
    private String mena;
    private Boolean platbaKartou;
    private Boolean sleva;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "datum_vytvoreni")
    public Timestamp getDatumVytvoreni() {
        return datumVytvoreni;
    }

    public void setDatumVytvoreni(Timestamp datumVytvoreni) {
        this.datumVytvoreni = datumVytvoreni;
    }

    @Basic
    @Column(name = "mena")
    public String getMena() {
        return mena;
    }

    public void setMena(String mena) {
        this.mena = mena;
    }

    @Basic
    @Column(name = "platba_kartou")
    public Boolean getPlatbaKartou() {
        return platbaKartou;
    }

    public void setPlatbaKartou(Boolean platbaKartou) {
        this.platbaKartou = platbaKartou;
    }

    @Basic
    @Column(name = "sleva")
    public Boolean getSleva() {
        return sleva;
    }

    public void setSleva(Boolean sleva) {
        this.sleva = sleva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UcetEntity that = (UcetEntity) o;
        return id == that.id &&
                Objects.equals(datumVytvoreni, that.datumVytvoreni) &&
                Objects.equals(mena, that.mena) &&
                Objects.equals(platbaKartou, that.platbaKartou) &&
                Objects.equals(sleva, that.sleva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datumVytvoreni, mena, platbaKartou, sleva);
    }

}
