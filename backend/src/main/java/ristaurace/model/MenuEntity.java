// Tomáš Vopat - vopattom

package ristaurace.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Menu", schema = "public", catalog = "ristaurace")
public class MenuEntity {
    private String jazyk;
    private Timestamp platneDo;
    private Timestamp platneOd;
    private long menuId;
    private Collection<RPolozkaMenuMenuEntity> rPolozkaMenuMenusByMenuId;

    @Basic
    @Column(name = "Jazyk")
    public String getJazyk() {
        return jazyk;
    }

    public void setJazyk(String jazyk) {
        this.jazyk = jazyk;
    }

    @Basic
    @Column(name = "Platne_do")
    public Timestamp getPlatneDo() {
        return platneDo;
    }

    public void setPlatneDo(Timestamp platneDo) {
        this.platneDo = platneDo;
    }

    @Basic
    @Column(name = "Platne_od")
    public Timestamp getPlatneOd() {
        return platneOd;
    }

    public void setPlatneOd(Timestamp platneOd) {
        this.platneOd = platneOd;
    }

    @Id
    @Column(name = "MenuID")
    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuEntity that = (MenuEntity) o;
        return menuId == that.menuId &&
                Objects.equals(jazyk, that.jazyk) &&
                Objects.equals(platneDo, that.platneDo) &&
                Objects.equals(platneOd, that.platneOd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jazyk, platneDo, platneOd, menuId);
    }

    @OneToMany(mappedBy = "menuByMenuId")
    public Collection<RPolozkaMenuMenuEntity> getrPolozkaMenuMenusByMenuId() {
        return rPolozkaMenuMenusByMenuId;
    }

    public void setrPolozkaMenuMenusByMenuId(Collection<RPolozkaMenuMenuEntity> rPolozkaMenuMenusByMenuId) {
        this.rPolozkaMenuMenusByMenuId = rPolozkaMenuMenusByMenuId;
    }
}
