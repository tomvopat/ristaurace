// Tomáš Vopat - vopattom

package ristaurace.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Popularita", schema = "public", catalog = "ristaurace")
public class PopularitaEntity {
    private Timestamp datum;
    private BigDecimal hodnota;
    private long popularitaId;
    private Long polozkaMenuId;

    @Basic
    @Column(name = "Datum")
    public Timestamp getDatum() {
        return datum;
    }

    public void setDatum(Timestamp datum) {
        this.datum = datum;
    }

    @Basic
    @Column(name = "Hodnota")
    public BigDecimal getHodnota() {
        return hodnota;
    }

    public void setHodnota(BigDecimal hodnota) {
        this.hodnota = hodnota;
    }

    @Id
    @Column(name = "PopularitaID")
    public long getPopularitaId() {
        return popularitaId;
    }

    public void setPopularitaId(long popularitaId) {
        this.popularitaId = popularitaId;
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
        PopularitaEntity that = (PopularitaEntity) o;
        return popularitaId == that.popularitaId &&
                Objects.equals(datum, that.datum) &&
                Objects.equals(hodnota, that.hodnota) &&
                Objects.equals(polozkaMenuId, that.polozkaMenuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datum, hodnota, popularitaId, polozkaMenuId);
    }
}
