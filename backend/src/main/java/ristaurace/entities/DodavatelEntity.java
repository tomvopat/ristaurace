// Tomáš Vopat - vopattom

package ristaurace.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Dodavatel", schema = "public", catalog = "ristaurace")
public class DodavatelEntity {
    private String adresa;
    private String dic;
    private String eMail;
    private String ico;
    private String nazev;
    private String telefon;
    private long dodavatelId;
    private Collection<ObjednavkaEntity> objednavkasByDodavatelId;

    @Basic
    @Column(name = "Adresa")
    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Basic
    @Column(name = "Dic")
    public String getDic() {
        return dic;
    }

    public void setDic(String dic) {
        this.dic = dic;
    }

    @Basic
    @Column(name = "E-mail")
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Basic
    @Column(name = "Ico")
    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    @Basic
    @Column(name = "Nazev")
    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    @Basic
    @Column(name = "Telefon")
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Id
    @Column(name = "DodavatelID")
    public long getDodavatelId() {
        return dodavatelId;
    }

    public void setDodavatelId(long dodavatelId) {
        this.dodavatelId = dodavatelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DodavatelEntity that = (DodavatelEntity) o;
        return dodavatelId == that.dodavatelId &&
                Objects.equals(adresa, that.adresa) &&
                Objects.equals(dic, that.dic) &&
                Objects.equals(eMail, that.eMail) &&
                Objects.equals(ico, that.ico) &&
                Objects.equals(nazev, that.nazev) &&
                Objects.equals(telefon, that.telefon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adresa, dic, eMail, ico, nazev, telefon, dodavatelId);
    }

    @OneToMany(mappedBy = "dodavatelByDodavatelId")
    public Collection<ObjednavkaEntity> getObjednavkasByDodavatelId() {
        return objednavkasByDodavatelId;
    }

    public void setObjednavkasByDodavatelId(Collection<ObjednavkaEntity> objednavkasByDodavatelId) {
        this.objednavkasByDodavatelId = objednavkasByDodavatelId;
    }
}
