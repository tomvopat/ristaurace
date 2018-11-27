// Tomáš Vopat - vopattom

package ristaurace.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Stav_polozky", schema = "public", catalog = "ristaurace")
public class StavPolozkyEntity {
    private Timestamp casVytvoreni;
    private String stav;
    private long stavPolozkyId;
    private Long polozkaMenuId;
    private Long ucetId;
    private PolozkaMenuEntity polozkaMenuByPolozkaMenuId;
    private UcetEntity ucetByUcetId;

    @Basic
    @Column(name = "Cas_vytvoreni")
    public Timestamp getCasVytvoreni() {
        return casVytvoreni;
    }

    public void setCasVytvoreni(Timestamp casVytvoreni) {
        this.casVytvoreni = casVytvoreni;
    }

    @Basic
    @Column(name = "Stav")
    public String getStav() {
        return stav;
    }

    public void setStav(String stav) {
        this.stav = stav;
    }

    @Id
    @Column(name = "Stav_polozkyID")
    public long getStavPolozkyId() {
        return stavPolozkyId;
    }

    public void setStavPolozkyId(long stavPolozkyId) {
        this.stavPolozkyId = stavPolozkyId;
    }

    @Basic
    @Column(name = "Polozka_menuID")
    public Long getPolozkaMenuId() {
        return polozkaMenuId;
    }

    public void setPolozkaMenuId(Long polozkaMenuId) {
        this.polozkaMenuId = polozkaMenuId;
    }

    @Basic
    @Column(name = "UcetID")
    public Long getUcetId() {
        return ucetId;
    }

    public void setUcetId(Long ucetId) {
        this.ucetId = ucetId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StavPolozkyEntity that = (StavPolozkyEntity) o;
        return stavPolozkyId == that.stavPolozkyId &&
                Objects.equals(casVytvoreni, that.casVytvoreni) &&
                Objects.equals(stav, that.stav) &&
                Objects.equals(polozkaMenuId, that.polozkaMenuId) &&
                Objects.equals(ucetId, that.ucetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(casVytvoreni, stav, stavPolozkyId, polozkaMenuId, ucetId);
    }

    @ManyToOne
    @JoinColumn(name = "Polozka_menuID", referencedColumnName = "Polozka_menuID")
    public PolozkaMenuEntity getPolozkaMenuByPolozkaMenuId() {
        return polozkaMenuByPolozkaMenuId;
    }

    public void setPolozkaMenuByPolozkaMenuId(PolozkaMenuEntity polozkaMenuByPolozkaMenuId) {
        this.polozkaMenuByPolozkaMenuId = polozkaMenuByPolozkaMenuId;
    }

    @ManyToOne
    @JoinColumn(name = "UcetID", referencedColumnName = "UcetID")
    public UcetEntity getUcetByUcetId() {
        return ucetByUcetId;
    }

    public void setUcetByUcetId(UcetEntity ucetByUcetId) {
        this.ucetByUcetId = ucetByUcetId;
    }
}
