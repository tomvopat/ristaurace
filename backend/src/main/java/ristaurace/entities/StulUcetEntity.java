// Tomáš Vopat - vopattom

package ristaurace.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stul_ucet", schema = "public", catalog = "ristaurace")
public class StulUcetEntity {
    private int id;
    private int idStul;
    private int idUcet;
    private StulEntity stulByIdStul;
    private UcetEntity ucetByIdUcet;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_stul")
    public int getIdStul() {
        return idStul;
    }

    public void setIdStul(int idStul) {
        this.idStul = idStul;
    }

    @Basic
    @Column(name = "id_ucet")
    public int getIdUcet() {
        return idUcet;
    }

    public void setIdUcet(int idUcet) {
        this.idUcet = idUcet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StulUcetEntity that = (StulUcetEntity) o;
        return id == that.id &&
                idStul == that.idStul &&
                idUcet == that.idUcet;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idStul, idUcet);
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
