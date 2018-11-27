// Tomáš Vopat - vopattom

package ristaurace.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "Objednane_zbozi", schema = "public", catalog = "ristaurace")
public class ObjednaneZboziEntity {
    private BigDecimal mnozstvi;
    private long objednaneZboziId;
    private long objednavkaId;
    private Long surovinaId;
    private ObjednavkaEntity objednavkaByObjednavkaId;
    private SurovinaEntity surovinaBySurovinaId;

    @Basic
    @Column(name = "Mnozstvi")
    public BigDecimal getMnozstvi() {
        return mnozstvi;
    }

    public void setMnozstvi(BigDecimal mnozstvi) {
        this.mnozstvi = mnozstvi;
    }

    @Id
    @Column(name = "Objednane_zboziID")
    public long getObjednaneZboziId() {
        return objednaneZboziId;
    }

    public void setObjednaneZboziId(long objednaneZboziId) {
        this.objednaneZboziId = objednaneZboziId;
    }

    @Basic
    @Column(name = "ObjednavkaID")
    public long getObjednavkaId() {
        return objednavkaId;
    }

    public void setObjednavkaId(long objednavkaId) {
        this.objednavkaId = objednavkaId;
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
        ObjednaneZboziEntity that = (ObjednaneZboziEntity) o;
        return objednaneZboziId == that.objednaneZboziId &&
                objednavkaId == that.objednavkaId &&
                Objects.equals(mnozstvi, that.mnozstvi) &&
                Objects.equals(surovinaId, that.surovinaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mnozstvi, objednaneZboziId, objednavkaId, surovinaId);
    }

    @ManyToOne
    @JoinColumn(name = "ObjednavkaID", referencedColumnName = "ObjednavkaID", nullable = false)
    public ObjednavkaEntity getObjednavkaByObjednavkaId() {
        return objednavkaByObjednavkaId;
    }

    public void setObjednavkaByObjednavkaId(ObjednavkaEntity objednavkaByObjednavkaId) {
        this.objednavkaByObjednavkaId = objednavkaByObjednavkaId;
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
