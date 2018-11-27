// Tomáš Vopat - vopattom

package ristaurace.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "R_Stul_Rezervace", schema = "public", catalog = "ristaurace")
public class RStulRezervaceEntity {
    private Long stulId;
    private Long rezervaceId;
    private StulEntity stulByStulId;
    private RezervaceEntity rezervaceByRezervaceId;

    @Basic
    @Column(name = "StulID")
    public Long getStulId() {
        return stulId;
    }

    public void setStulId(Long stulId) {
        this.stulId = stulId;
    }

    @Basic
    @Column(name = "RezervaceID")
    public Long getRezervaceId() {
        return rezervaceId;
    }

    public void setRezervaceId(Long rezervaceId) {
        this.rezervaceId = rezervaceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RStulRezervaceEntity that = (RStulRezervaceEntity) o;
        return Objects.equals(stulId, that.stulId) &&
                Objects.equals(rezervaceId, that.rezervaceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stulId, rezervaceId);
    }

    @ManyToOne
    @JoinColumn(name = "StulID", referencedColumnName = "StulID")
    public StulEntity getStulByStulId() {
        return stulByStulId;
    }

    public void setStulByStulId(StulEntity stulByStulId) {
        this.stulByStulId = stulByStulId;
    }

    @ManyToOne
    @JoinColumn(name = "RezervaceID", referencedColumnName = "RezervaceID")
    public RezervaceEntity getRezervaceByRezervaceId() {
        return rezervaceByRezervaceId;
    }

    public void setRezervaceByRezervaceId(RezervaceEntity rezervaceByRezervaceId) {
        this.rezervaceByRezervaceId = rezervaceByRezervaceId;
    }
}
