// Tomáš Vopat - vopattom

package ristaurace.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "stul", schema = "public", catalog = "ristaurace")
public class StulEntity {
    private int id;
    private int cisloStolu;
    private int pocetMist;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cislo_stolu")
    public int getCisloStolu() {
        return cisloStolu;
    }

    public void setCisloStolu(int cisloStolu) {
        this.cisloStolu = cisloStolu;
    }

    @Basic
    @Column(name = "pocet_mist")
    public int getPocetMist() {
        return pocetMist;
    }

    public void setPocetMist(int pocetMist) {
        this.pocetMist = pocetMist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StulEntity that = (StulEntity) o;
        return id == that.id &&
                cisloStolu == that.cisloStolu &&
                pocetMist == that.pocetMist;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cisloStolu, pocetMist);
    }
}
