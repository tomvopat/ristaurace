// Tomáš Vopat - vopattom

package ristaurace.dataLayer.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

/**
 * Třída mapující databázovou entitu "menu" na java objekt.
 * Více info viz dokumentace relačního modelu.
 */
@Entity
@Table(name = "menu", schema = "public", catalog = "ristaurace")
public class MenuEntity {
    private int id;
    private Timestamp platneOd;
    private Timestamp platneDo;
    private String jazyk;
    private Collection<MenuPolozkaMenuEntity> menuPolozkaMenusById;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "platne_od")
    public Timestamp getPlatneOd() {
        return platneOd;
    }

    public void setPlatneOd(Timestamp platneOd) {
        this.platneOd = platneOd;
    }

    @Basic
    @Column(name = "platne_do")
    public Timestamp getPlatneDo() {
        return platneDo;
    }

    public void setPlatneDo(Timestamp platneDo) {
        this.platneDo = platneDo;
    }

    @Basic
    @Column(name = "jazyk")
    public String getJazyk() {
        return jazyk;
    }

    public void setJazyk(String jazyk) {
        this.jazyk = jazyk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuEntity that = (MenuEntity) o;
        return id == that.id &&
                Objects.equals(platneOd, that.platneOd) &&
                Objects.equals(platneDo, that.platneDo) &&
                Objects.equals(jazyk, that.jazyk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, platneOd, platneDo, jazyk);
    }

    @OneToMany(mappedBy = "menuByIdMenu")
    public Collection<MenuPolozkaMenuEntity> getMenuPolozkaMenusById() {
        return menuPolozkaMenusById;
    }

    public void setMenuPolozkaMenusById(Collection<MenuPolozkaMenuEntity> menuPolozkaMenusById) {
        this.menuPolozkaMenusById = menuPolozkaMenusById;
    }
}
