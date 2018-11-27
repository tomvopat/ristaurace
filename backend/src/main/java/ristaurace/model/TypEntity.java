// Tomáš Vopat - vopattom

package ristaurace.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Typ", schema = "public", catalog = "ristaurace")
public class TypEntity {
    private String nazev;
    private long typId;
    private Collection<RPolozkaMenuTypEntity> rPolozkaMenuTypsByTypId;

    @Basic
    @Column(name = "Nazev")
    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    @Id
    @Column(name = "TypID")
    public long getTypId() {
        return typId;
    }

    public void setTypId(long typId) {
        this.typId = typId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypEntity typEntity = (TypEntity) o;
        return typId == typEntity.typId &&
                Objects.equals(nazev, typEntity.nazev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazev, typId);
    }

    @OneToMany(mappedBy = "typByTypId")
    public Collection<RPolozkaMenuTypEntity> getrPolozkaMenuTypsByTypId() {
        return rPolozkaMenuTypsByTypId;
    }

    public void setrPolozkaMenuTypsByTypId(Collection<RPolozkaMenuTypEntity> rPolozkaMenuTypsByTypId) {
        this.rPolozkaMenuTypsByTypId = rPolozkaMenuTypsByTypId;
    }
}
