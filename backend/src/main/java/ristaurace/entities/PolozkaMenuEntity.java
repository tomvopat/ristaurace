// Tomáš Vopat - vopattom

package ristaurace.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "polozka_menu", schema = "public", catalog = "ristaurace")
public class PolozkaMenuEntity {
    private int id;
    private String nazev;
    private float cena;
    private Collection<MenuPolozkaMenuEntity> menuPolozkaMenusById;
    private Collection<PopularitaEntity> popularitasById;
    private Collection<StavPolozkyEntity> stavPolozkiesById;
    private Collection<TypPolozkaMenuEntity> typPolozkaMenusById;

    @Id
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

    @OneToMany(mappedBy = "polozkaMenuByIdPolozkaMenu")
    public Collection<MenuPolozkaMenuEntity> getMenuPolozkaMenusById() {
        return menuPolozkaMenusById;
    }

    public void setMenuPolozkaMenusById(Collection<MenuPolozkaMenuEntity> menuPolozkaMenusById) {
        this.menuPolozkaMenusById = menuPolozkaMenusById;
    }

    @OneToMany(mappedBy = "polozkaMenuByIdPolozkaMenu")
    public Collection<PopularitaEntity> getPopularitasById() {
        return popularitasById;
    }

    public void setPopularitasById(Collection<PopularitaEntity> popularitasById) {
        this.popularitasById = popularitasById;
    }

    @OneToMany(mappedBy = "polozkaMenuByIdPolozkaMenu")
    public Collection<StavPolozkyEntity> getStavPolozkiesById() {
        return stavPolozkiesById;
    }

    public void setStavPolozkiesById(Collection<StavPolozkyEntity> stavPolozkiesById) {
        this.stavPolozkiesById = stavPolozkiesById;
    }

    @OneToMany(mappedBy = "polozkaMenuByIdPolozkaMenu")
    public Collection<TypPolozkaMenuEntity> getTypPolozkaMenusById() {
        return typPolozkaMenusById;
    }

    public void setTypPolozkaMenusById(Collection<TypPolozkaMenuEntity> typPolozkaMenusById) {
        this.typPolozkaMenusById = typPolozkaMenusById;
    }
}
