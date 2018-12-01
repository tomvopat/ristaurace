// Tomáš Vopat - vopattom

package ristaurace.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "stav_polozky", schema = "public", catalog = "ristaurace")
public class StavPolozkyEntity {
    private int id;
    private String stav;
    private Timestamp casVytvoreni;
    private UcetEntity ucetByIdUcet;
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
    @Column(name = "stav")
    public String getStav() {
        return stav;
    }

    public void setStav(String stav) {
        this.stav = stav;
    }

    @Basic
    @Column(name = "cas_vytvoreni")
    public Timestamp getCasVytvoreni() {
        return casVytvoreni;
    }

    public void setCasVytvoreni(Timestamp casVytvoreni) {
        this.casVytvoreni = casVytvoreni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StavPolozkyEntity that = (StavPolozkyEntity) o;
        return id == that.id &&
                ucetByIdUcet.getId() == that.ucetByIdUcet.getId() &&
                polozkaMenuByIdPolozkaMenu.getId() == that.polozkaMenuByIdPolozkaMenu.getId() &&
                Objects.equals(stav, that.stav) &&
                Objects.equals(casVytvoreni, that.casVytvoreni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ucetByIdUcet.getId(), polozkaMenuByIdPolozkaMenu.getId(), stav, casVytvoreni);
    }

    @ManyToOne
    @JoinColumn(name = "id_ucet", referencedColumnName = "id", nullable = false)
    public UcetEntity getUcetByIdUcet() {
        return ucetByIdUcet;
    }

    public void setUcetByIdUcet(UcetEntity ucetByIdUcet) {
        this.ucetByIdUcet = ucetByIdUcet;
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