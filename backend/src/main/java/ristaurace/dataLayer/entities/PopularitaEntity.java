// Tomáš Vopat - vopattom

package ristaurace.dataLayer.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Třída mapující databázovou entitu "popularita" na java objekt.
 * Více info viz dokumentace relačního modelu.
 */
@Entity
@Table(name = "popularita", schema = "public", catalog = "ristaurace")
public class PopularitaEntity {
    private int id;
    private float hodnota;
    private Timestamp datum;
    private PolozkaMenuEntity polozkaMenuByIdPolozkaMenu;

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
    @Column(name = "hodnota")
    public float getHodnota() {
        return hodnota;
    }

    public void setHodnota(float hodnota) {
        this.hodnota = hodnota;
    }

    @Basic
    @Column(name = "datum")
    public Timestamp getDatum() {
        return datum;
    }

    public void setDatum(Timestamp datum) {
        this.datum = datum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PopularitaEntity that = (PopularitaEntity) o;
        return id == that.id &&
                polozkaMenuByIdPolozkaMenu.getId() == that.polozkaMenuByIdPolozkaMenu.getId() &&
                Float.compare(that.hodnota, hodnota) == 0 &&
                Objects.equals(datum, that.datum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, polozkaMenuByIdPolozkaMenu.getId(), hodnota, datum);
    }

    @ManyToOne
    @JoinColumn(name = "id_polozka_menu", referencedColumnName = "id", nullable = false)
    public PolozkaMenuEntity getPolozkaMenuByIdPolozkaMenu() {
        return polozkaMenuByIdPolozkaMenu;
    }

    public void setPolozkaMenuByIdPolozkaMenu(PolozkaMenuEntity polozkaMenuByIdPolozkaMenu) {
        this.polozkaMenuByIdPolozkaMenu = polozkaMenuByIdPolozkaMenu;
    }
}
