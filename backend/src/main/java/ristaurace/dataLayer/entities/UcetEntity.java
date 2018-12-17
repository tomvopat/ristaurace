// Tomáš Vopat - vopattom

package ristaurace.dataLayer.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Třída mapující databázovou entitu "ucet" na java objekt.
 * Více info viz dokumentace relačního modelu.
 */
@Entity
@Table(name = "ucet", schema = "public", catalog = "ristaurace")
public class UcetEntity {
    private int id;
    private Timestamp datumVytvoreni;
    private String mena;
    private Boolean platbaKartou;

    @Id
    @SequenceGenerator(name="ucet_generator", sequenceName = "ucet_id_seq", allocationSize=50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ucet_generator")
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "datum_vytvoreni", insertable = false)
    public Timestamp getDatumVytvoreni() {
        return datumVytvoreni;
    }

    public void setDatumVytvoreni(Timestamp datumVytvoreni) {
        this.datumVytvoreni = datumVytvoreni;
    }

    @Basic
    @Column(name = "mena", insertable = false)
    public String getMena() {
        return mena;
    }

    public void setMena(String mena) {
        this.mena = mena;
    }

    @Basic
    @Column(name = "platba_kartou", insertable = false)
    public Boolean getPlatbaKartou() {
        return platbaKartou;
    }

    public void setPlatbaKartou(Boolean platbaKartou) {
        this.platbaKartou = platbaKartou;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UcetEntity that = (UcetEntity) o;
        return id == that.id &&
                Objects.equals(datumVytvoreni, that.datumVytvoreni) &&
                Objects.equals(mena, that.mena) &&
                Objects.equals(platbaKartou, that.platbaKartou);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datumVytvoreni, mena, platbaKartou);
    }

}
