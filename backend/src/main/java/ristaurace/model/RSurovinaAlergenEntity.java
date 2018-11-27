// Tomáš Vopat - vopattom

package ristaurace.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "R_Surovina_Alergen", schema = "public", catalog = "ristaurace")
public class RSurovinaAlergenEntity {
    private Long alergenId;
    private Long surovinaId;
    private AlergenEntity alergenByAlergenId;
    private SurovinaEntity surovinaBySurovinaId;

    @Basic
    @Column(name = "AlergenID")
    public Long getAlergenId() {
        return alergenId;
    }

    public void setAlergenId(Long alergenId) {
        this.alergenId = alergenId;
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
        RSurovinaAlergenEntity that = (RSurovinaAlergenEntity) o;
        return Objects.equals(alergenId, that.alergenId) &&
                Objects.equals(surovinaId, that.surovinaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alergenId, surovinaId);
    }

    @ManyToOne
    @JoinColumn(name = "AlergenID", referencedColumnName = "AlergenID")
    public AlergenEntity getAlergenByAlergenId() {
        return alergenByAlergenId;
    }

    public void setAlergenByAlergenId(AlergenEntity alergenByAlergenId) {
        this.alergenByAlergenId = alergenByAlergenId;
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
