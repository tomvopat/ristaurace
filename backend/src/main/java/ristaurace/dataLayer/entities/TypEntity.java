// Tomáš Vopat - vopattom

package ristaurace.dataLayer.entities;

import javax.persistence.*;
import java.util.Objects;

/**
 * Třída mapující databázovou entitu "typ" na java objekt.
 * Více info viz dokumentace relačního modelu.
 */
@Entity
@Table(name = "typ", schema = "public", catalog = "ristaurace")
public class TypEntity {
    private int id;
    private String nazev;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypEntity typEntity = (TypEntity) o;
        return id == typEntity.id &&
                Objects.equals(nazev, typEntity.nazev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazev);
    }

}
