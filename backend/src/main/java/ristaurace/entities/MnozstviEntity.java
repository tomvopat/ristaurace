// Tomáš Vopat - vopattom

package ristaurace.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "Mnozstvi", schema = "public", catalog = "ristaurace")
public class MnozstviEntity {
    private BigDecimal pocet;
    private long mnozstviId;
    private Long surovinaId;
    private Long polozkaMenuId;
    private SurovinaEntity surovinaBySurovinaId;

    @Basic
    @Column(name = "Pocet")
    public BigDecimal getPocet() {
        return pocet;
    }

    public void setPocet(BigDecimal pocet) {
        this.pocet = pocet;
    }

    @Id
    @Column(name = "MnozstviID")
    public long getMnozstviId() {
        return mnozstviId;
    }

    public void setMnozstviId(long mnozstviId) {
        this.mnozstviId = mnozstviId;
    }

    @Basic
    @Column(name = "SurovinaID")
    public Long getSurovinaId() {
        return surovinaId;
    }

    public void setSurovinaId(Long surovinaId) {
        this.surovinaId = surovinaId;
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
        MnozstviEntity that = (MnozstviEntity) o;
        return mnozstviId == that.mnozstviId &&
                Objects.equals(pocet, that.pocet) &&
                Objects.equals(surovinaId, that.surovinaId) &&
                Objects.equals(polozkaMenuId, that.polozkaMenuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pocet, mnozstviId, surovinaId, polozkaMenuId);
    }

    @ManyToOne
    @JoinColumn(name = "SurovinaID", referencedColumnName = "SurovinaID")
    public SurovinaEntity getSurovinaBySurovinaId() {
        return surovinaBySurovinaId;
    }

    public void setSurovinaBySurovinaId(SurovinaEntity surovinaBySurovinaId) {
        this.surovinaBySurovinaId = surovinaBySurovinaId;
    }
}
