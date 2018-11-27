// Tomáš Vopat - vopattom

package ristaurace.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "R_PolozkaMenu_Typ", schema = "public", catalog = "ristaurace")
public class RPolozkaMenuTypEntity {
    private Long typId;
    private Long polozkaMenuId;
    private TypEntity typByTypId;

    @Basic
    @Column(name = "TypID")
    public Long getTypId() {
        return typId;
    }

    public void setTypId(Long typId) {
        this.typId = typId;
    }

    @Basic
    @Column(name = "Polozka_menuID")
    public Long getPolozkaMenuId() {
        return polozkaMenuId;
    }

    public void setPolozkaMenuId(Long polozkaMenuId) {
        this.polozkaMenuId = polozkaMenuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RPolozkaMenuTypEntity that = (RPolozkaMenuTypEntity) o;
        return Objects.equals(typId, that.typId) &&
                Objects.equals(polozkaMenuId, that.polozkaMenuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typId, polozkaMenuId);
    }

    @ManyToOne
    @JoinColumn(name = "TypID", referencedColumnName = "TypID")
    public TypEntity getTypByTypId() {
        return typByTypId;
    }

    public void setTypByTypId(TypEntity typByTypId) {
        this.typByTypId = typByTypId;
    }
}
