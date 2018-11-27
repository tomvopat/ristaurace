// Tomáš Vopat - vopattom

package ristaurace.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Zasoba", schema = "public", catalog = "ristaurace")
public class ZasobaEntity {
    private BigDecimal mnostvi;
    private Timestamp trvanlivost;
    private long zasobaId;
    private Long surovinaId;
    private SurovinaEntity surovinaBySurovinaId;

    @Basic
    @Column(name = "Mnostvi")
    public BigDecimal getMnostvi() {
        return mnostvi;
    }

    public void setMnostvi(BigDecimal mnostvi) {
        this.mnostvi = mnostvi;
    }

    @Basic
    @Column(name = "Trvanlivost")
    public Timestamp getTrvanlivost() {
        return trvanlivost;
    }

    public void setTrvanlivost(Timestamp trvanlivost) {
        this.trvanlivost = trvanlivost;
    }

    @Id
    @Column(name = "ZasobaID")
    public long getZasobaId() {
        return zasobaId;
    }

    public void setZasobaId(long zasobaId) {
        this.zasobaId = zasobaId;
    }

    @Basic
    @Column(name = "SurovinaID")
    public Long getSurovinaId() {
        return surovinaId;
    }

    public void setSurovinaId(Long surovinaId) {
        this.surovinaId = surovinaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZasobaEntity that = (ZasobaEntity) o;
        return zasobaId == that.zasobaId &&
                Objects.equals(mnostvi, that.mnostvi) &&
                Objects.equals(trvanlivost, that.trvanlivost) &&
                Objects.equals(surovinaId, that.surovinaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mnostvi, trvanlivost, zasobaId, surovinaId);
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
