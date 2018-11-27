// Tomáš Vopat - vopattom

package ristaurace.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Surovina", schema = "public", catalog = "ristaurace")
public class SurovinaEntity {
    private String nazev;
    private long surovinaId;
    private Collection<MnozstviEntity> mnozstvisBySurovinaId;
    private Collection<ObjednaneZboziEntity> objednaneZbozisBySurovinaId;
    private Collection<RSurovinaAlergenEntity> rSurovinaAlergensBySurovinaId;
    private Collection<ZasobaEntity> zasobasBySurovinaId;

    @Basic
    @Column(name = "Nazev")
    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    @Id
    @Column(name = "SurovinaID")
    public long getSurovinaId() {
        return surovinaId;
    }

    public void setSurovinaId(long surovinaId) {
        this.surovinaId = surovinaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SurovinaEntity that = (SurovinaEntity) o;
        return surovinaId == that.surovinaId &&
                Objects.equals(nazev, that.nazev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazev, surovinaId);
    }

    @OneToMany(mappedBy = "surovinaBySurovinaId")
    public Collection<MnozstviEntity> getMnozstvisBySurovinaId() {
        return mnozstvisBySurovinaId;
    }

    public void setMnozstvisBySurovinaId(Collection<MnozstviEntity> mnozstvisBySurovinaId) {
        this.mnozstvisBySurovinaId = mnozstvisBySurovinaId;
    }

    @OneToMany(mappedBy = "surovinaBySurovinaId")
    public Collection<ObjednaneZboziEntity> getObjednaneZbozisBySurovinaId() {
        return objednaneZbozisBySurovinaId;
    }

    public void setObjednaneZbozisBySurovinaId(Collection<ObjednaneZboziEntity> objednaneZbozisBySurovinaId) {
        this.objednaneZbozisBySurovinaId = objednaneZbozisBySurovinaId;
    }

    @OneToMany(mappedBy = "surovinaBySurovinaId")
    public Collection<RSurovinaAlergenEntity> getrSurovinaAlergensBySurovinaId() {
        return rSurovinaAlergensBySurovinaId;
    }

    public void setrSurovinaAlergensBySurovinaId(Collection<RSurovinaAlergenEntity> rSurovinaAlergensBySurovinaId) {
        this.rSurovinaAlergensBySurovinaId = rSurovinaAlergensBySurovinaId;
    }

    @OneToMany(mappedBy = "surovinaBySurovinaId")
    public Collection<ZasobaEntity> getZasobasBySurovinaId() {
        return zasobasBySurovinaId;
    }

    public void setZasobasBySurovinaId(Collection<ZasobaEntity> zasobasBySurovinaId) {
        this.zasobasBySurovinaId = zasobasBySurovinaId;
    }
}
