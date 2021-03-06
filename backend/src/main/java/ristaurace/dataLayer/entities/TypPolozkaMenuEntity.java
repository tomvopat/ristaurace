// Tomáš Vopat - vopattom

package ristaurace.dataLayer.entities;

import javax.persistence.*;
import java.util.Objects;

/**
 * Třída mapující databázovou entitu "typ_polozka_menu" na java objekt.
 * Více info viz dokumentace relačního modelu.
 */
@Entity
@Table(name = "typ_polozka_menu", schema = "public", catalog = "ristaurace")
public class TypPolozkaMenuEntity {
    private int id;
    private TypEntity typByIdTyp;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypPolozkaMenuEntity that = (TypPolozkaMenuEntity) o;
        return id == that.id &&
                typByIdTyp.getId() == that.typByIdTyp.getId() &&
                polozkaMenuByIdPolozkaMenu.getId() == that.polozkaMenuByIdPolozkaMenu.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typByIdTyp.getId(), polozkaMenuByIdPolozkaMenu.getId());
    }

    @ManyToOne
    @JoinColumn(name = "id_typ", referencedColumnName = "id", nullable = false)
    public TypEntity getTypByIdTyp() {
        return typByIdTyp;
    }

    public void setTypByIdTyp(TypEntity typByIdTyp) {
        this.typByIdTyp = typByIdTyp;
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
