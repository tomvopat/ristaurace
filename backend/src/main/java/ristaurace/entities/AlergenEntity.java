// Tomáš Vopat - vopattom

package ristaurace.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Alergen", schema = "public", catalog = "ristaurace")
public class AlergenEntity {
    private String nazev;
    private String popis;
    private long alergenId;
    private Collection<RSurovinaAlergenEntity> rSurovinaAlergensByAlergenId;

    @Basic
    @Column(name = "Nazev")
    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    @Basic
    @Column(name = "Popis")
    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    @Id
    @Column(name = "AlergenID")
    public long getAlergenId() {
        return alergenId;
    }

    public void setAlergenId(long alergenId) {
        this.alergenId = alergenId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlergenEntity that = (AlergenEntity) o;
        return alergenId == that.alergenId &&
                Objects.equals(nazev, that.nazev) &&
                Objects.equals(popis, that.popis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazev, popis, alergenId);
    }

    @OneToMany(mappedBy = "alergenByAlergenId")
    public Collection<RSurovinaAlergenEntity> getrSurovinaAlergensByAlergenId() {
        return rSurovinaAlergensByAlergenId;
    }

    public void setrSurovinaAlergensByAlergenId(Collection<RSurovinaAlergenEntity> rSurovinaAlergensByAlergenId) {
        this.rSurovinaAlergensByAlergenId = rSurovinaAlergensByAlergenId;
    }
}
