// Tomáš Vopat - vopattom

package ristaurace.entities;

import ristaurace.helpObjects.StavEnum;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stul_ucet", schema = "public", catalog = "ristaurace")
public class StulUcetEntity {

    private int id;
    private StulEntity stulByIdStul;
    private UcetEntity ucetByIdUcet;
    private StavEnum stavEnum;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "stav")
    public StavEnum getStav() {
        return stavEnum;
    }
    public void setStav(StavEnum stav) {
        this.stavEnum = stav;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StulUcetEntity that = (StulUcetEntity) o;
        return id == that.id &&
                stulByIdStul.getId() == that.stulByIdStul.getId() &&
                ucetByIdUcet.getId() == that.ucetByIdUcet.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stulByIdStul.getId(), ucetByIdUcet.getId());
    }

    @ManyToOne
    @JoinColumn(name = "id_stul", referencedColumnName = "id", nullable = false)
    public StulEntity getStulByIdStul() {
        return stulByIdStul;
    }

    public void setStulByIdStul(StulEntity stulByIdStul) {
        this.stulByIdStul = stulByIdStul;
    }

    @ManyToOne
    @JoinColumn(name = "id_ucet", referencedColumnName = "id", nullable = false)
    public UcetEntity getUcetByIdUcet() {
        return ucetByIdUcet;
    }

    public void setUcetByIdUcet(UcetEntity ucetByIdUcet) {
        this.ucetByIdUcet = ucetByIdUcet;
    }
}
