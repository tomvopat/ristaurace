// Tomáš Vopat - vopattom

package ristaurace.dataLayer.entities;

import ristaurace.dataLayer.helpObjects.StavEnum;

import javax.persistence.*;
import java.util.Objects;

/**
 * Třída mapující databázovou entitu "stul_ucet" na java objekt.
 * Více info viz dokumentace relačního modelu.
 */
@Entity
@Table(name = "stul_ucet", schema = "public", catalog = "ristaurace")
public class StulUcetEntity {

    private int id;
    private StulEntity stulByIdStul;
    private UcetEntity ucetByIdUcet;
    private StavEnum stavEnum;

    @Id
    @SequenceGenerator(name="stulUcet_gen", sequenceName = "stul_ucet_seq", allocationSize=50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stulUcet_gen")
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "stav", insertable = false)
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
