// Tomáš Vopat - vopattom

package ristaurace.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Objednavka", schema = "public", catalog = "ristaurace")
public class ObjednavkaEntity {
    private Float cena;
    private Timestamp datumDodani;
    private Timestamp datumVytvoreni;
    private long objednavkaId;
    private Long dodavatelId;
    private Collection<ObjednaneZboziEntity> objednaneZbozisByObjednavkaId;
    private DodavatelEntity dodavatelByDodavatelId;

    @Basic
    @Column(name = "Cena")
    public Float getCena() {
        return cena;
    }

    public void setCena(Float cena) {
        this.cena = cena;
    }

    @Basic
    @Column(name = "Datum_dodani")
    public Timestamp getDatumDodani() {
        return datumDodani;
    }

    public void setDatumDodani(Timestamp datumDodani) {
        this.datumDodani = datumDodani;
    }

    @Basic
    @Column(name = "Datum_vytvoreni")
    public Timestamp getDatumVytvoreni() {
        return datumVytvoreni;
    }

    public void setDatumVytvoreni(Timestamp datumVytvoreni) {
        this.datumVytvoreni = datumVytvoreni;
    }

    @Id
    @Column(name = "ObjednavkaID")
    public long getObjednavkaId() {
        return objednavkaId;
    }

    public void setObjednavkaId(long objednavkaId) {
        this.objednavkaId = objednavkaId;
    }

    @Basic
    @Column(name = "DodavatelID")
    public Long getDodavatelId() {
        return dodavatelId;
    }

    public void setDodavatelId(Long dodavatelId) {
        this.dodavatelId = dodavatelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjednavkaEntity that = (ObjednavkaEntity) o;
        return objednavkaId == that.objednavkaId &&
                Objects.equals(cena, that.cena) &&
                Objects.equals(datumDodani, that.datumDodani) &&
                Objects.equals(datumVytvoreni, that.datumVytvoreni) &&
                Objects.equals(dodavatelId, that.dodavatelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cena, datumDodani, datumVytvoreni, objednavkaId, dodavatelId);
    }

    @OneToMany(mappedBy = "objednavkaByObjednavkaId")
    public Collection<ObjednaneZboziEntity> getObjednaneZbozisByObjednavkaId() {
        return objednaneZbozisByObjednavkaId;
    }

    public void setObjednaneZbozisByObjednavkaId(Collection<ObjednaneZboziEntity> objednaneZbozisByObjednavkaId) {
        this.objednaneZbozisByObjednavkaId = objednaneZbozisByObjednavkaId;
    }

    @ManyToOne
    @JoinColumn(name = "DodavatelID", referencedColumnName = "DodavatelID")
    public DodavatelEntity getDodavatelByDodavatelId() {
        return dodavatelByDodavatelId;
    }

    public void setDodavatelByDodavatelId(DodavatelEntity dodavatelByDodavatelId) {
        this.dodavatelByDodavatelId = dodavatelByDodavatelId;
    }
}
