// Tomáš Vopat - vopattom

package ristaurace.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "typ_polozka_menu", schema = "public", catalog = "ristaurace")
public class TypPolozkaMenuEntity {
    private int id;
    private int idTyp;
    private int idPolozkaMenu;
    private TypEntity typByIdTyp;
    private PolozkaMenuEntity polozkaMenuByIdPolozkaMenu;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_typ")
    public int getIdTyp() {
        return idTyp;
    }

    public void setIdTyp(int idTyp) {
        this.idTyp = idTyp;
    }

    @Basic
    @Column(name = "id_polozka_menu")
    public int getIdPolozkaMenu() {
        return idPolozkaMenu;
    }

    public void setIdPolozkaMenu(int idPolozkaMenu) {
        this.idPolozkaMenu = idPolozkaMenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypPolozkaMenuEntity that = (TypPolozkaMenuEntity) o;
        return id == that.id &&
                idTyp == that.idTyp &&
                idPolozkaMenu == that.idPolozkaMenu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idTyp, idPolozkaMenu);
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
