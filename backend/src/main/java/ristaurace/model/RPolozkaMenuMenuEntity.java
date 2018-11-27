// Tomáš Vopat - vopattom

package ristaurace.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "R_PolozkaMenu_Menu", schema = "public", catalog = "ristaurace")
public class RPolozkaMenuMenuEntity {
    private Long polozkaMenuId;
    private Long menuId;
    private MenuEntity menuByMenuId;

    @Basic
    @Column(name = "Polozka_menuID")
    public Long getPolozkaMenuId() {
        return polozkaMenuId;
    }

    public void setPolozkaMenuId(Long polozkaMenuId) {
        this.polozkaMenuId = polozkaMenuId;
    }

    @Basic
    @Column(name = "MenuID")
    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RPolozkaMenuMenuEntity that = (RPolozkaMenuMenuEntity) o;
        return Objects.equals(polozkaMenuId, that.polozkaMenuId) &&
                Objects.equals(menuId, that.menuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(polozkaMenuId, menuId);
    }

    @ManyToOne
    @JoinColumn(name = "MenuID", referencedColumnName = "MenuID")
    public MenuEntity getMenuByMenuId() {
        return menuByMenuId;
    }

    public void setMenuByMenuId(MenuEntity menuByMenuId) {
        this.menuByMenuId = menuByMenuId;
    }
}
