// Tomáš Vopat - vopattom

package ristaurace.dataLayer.entities;

import javax.persistence.*;
import java.util.Objects;

/**
 * Třída mapující databázovou entitu "polozka_menu" na java objekt.
 * Více info viz dokumentace relačního modelu.
 */
@Entity
@Table(name = "polozka_menu", schema = "public", catalog = "ristaurace")
public class PolozkaMenuEntity {
    private int id;
    private String nazev;
    private float cena;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nazev")
    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    @Basic
    @Column(name = "cena")
    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolozkaMenuEntity that = (PolozkaMenuEntity) o;
        return id == that.id &&
                Float.compare(that.cena, cena) == 0 &&
                Objects.equals(nazev, that.nazev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazev, cena);
    }
}
