// Tomáš Vopat - vopattom

package ristaurace.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "R_Ucet_Stul", schema = "public", catalog = "ristaurace")
public class RUcetStulEntity {
    private Long ucetId;
    private Long stulId;
    private UcetEntity ucetByUcetId;
    private StulEntity stulByStulId;

    @Basic
    @Column(name = "UcetID")
    public Long getUcetId() {
        return ucetId;
    }

    public void setUcetId(Long ucetId) {
        this.ucetId = ucetId;
    }

    @Basic
    @Column(name = "StulID")
    public Long getStulId() {
        return stulId;
    }

    public void setStulId(Long stulId) {
        this.stulId = stulId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RUcetStulEntity that = (RUcetStulEntity) o;
        return Objects.equals(ucetId, that.ucetId) &&
                Objects.equals(stulId, that.stulId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ucetId, stulId);
    }

    @ManyToOne
    @JoinColumn(name = "UcetID", referencedColumnName = "UcetID")
    public UcetEntity getUcetByUcetId() {
        return ucetByUcetId;
    }

    public void setUcetByUcetId(UcetEntity ucetByUcetId) {
        this.ucetByUcetId = ucetByUcetId;
    }

    @ManyToOne
    @JoinColumn(name = "StulID", referencedColumnName = "StulID")
    public StulEntity getStulByStulId() {
        return stulByStulId;
    }

    public void setStulByStulId(StulEntity stulByStulId) {
        this.stulByStulId = stulByStulId;
    }
}
