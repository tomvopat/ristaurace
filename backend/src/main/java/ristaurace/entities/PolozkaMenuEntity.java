// Tomáš Vopat - vopattom

package ristaurace.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Polozka_menu", schema = "public", catalog = "ristaurace")
public class PolozkaMenuEntity {
    private float cena;
    private String nazev;
    private long polozkaMenuId;
    private Collection<StavPolozkyEntity> stavPolozkiesByPolozkaMenuId;

    @Basic
    @Column(name = "Cena")
    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    @Basic
    @Column(name = "Nazev")
    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    @Id
    @Column(name = "Polozka_menuID")
    public long getPolozkaMenuId() {
        return polozkaMenuId;
    }

    public void setPolozkaMenuId(long polozkaMenuId) {
        this.polozkaMenuId = polozkaMenuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolozkaMenuEntity that = (PolozkaMenuEntity) o;
        return Float.compare(that.cena, cena) == 0 &&
                polozkaMenuId == that.polozkaMenuId &&
                Objects.equals(nazev, that.nazev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cena, nazev, polozkaMenuId);
    }

    @OneToMany(mappedBy = "polozkaMenuByPolozkaMenuId")
    public Collection<StavPolozkyEntity> getStavPolozkiesByPolozkaMenuId() {
        return stavPolozkiesByPolozkaMenuId;
    }

    public void setStavPolozkiesByPolozkaMenuId(Collection<StavPolozkyEntity> stavPolozkiesByPolozkaMenuId) {
        this.stavPolozkiesByPolozkaMenuId = stavPolozkiesByPolozkaMenuId;
    }
}
