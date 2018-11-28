// Tomáš Vopat - vopattom

package ristaurace.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "menu_polozka_menu", schema = "public", catalog = "ristaurace")
public class MenuPolozkaMenuEntity {
    private int id;
    private int idMenu;
    private int idPolozkaMenu;
    private MenuEntity menuByIdMenu;
    private PolozkaMenuEntity polozkaMenuByIdPolozkaMenu;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_menu")
    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    @Basic
    @Column(name = "id_polozka_menu")
    public int getIdPolozkaMenu() {
        return idPolozkaMenu;
    }

    public void setIdPolozkaMenu(int idPolozkaMenu) {
        this.idPolozkaMenu = idPolozkaMenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuPolozkaMenuEntity that = (MenuPolozkaMenuEntity) o;
        return id == that.id &&
                idMenu == that.idMenu &&
                idPolozkaMenu == that.idPolozkaMenu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idMenu, idPolozkaMenu);
    }

    @ManyToOne
    @JoinColumn(name = "id_menu", referencedColumnName = "id", nullable = false)
    public MenuEntity getMenuByIdMenu() {
        return menuByIdMenu;
    }

    public void setMenuByIdMenu(MenuEntity menuByIdMenu) {
        this.menuByIdMenu = menuByIdMenu;
    }

    @ManyToOne
    @JoinColumn(name = "id_polozka_menu", referencedColumnName = "id", nullable = false)
    public PolozkaMenuEntity getPolozkaMenuByIdPolozkaMenu() {
        return polozkaMenuByIdPolozkaMenu;
    }

    public void setPolozkaMenuByIdPolozkaMenu(PolozkaMenuEntity polozkaMenuByIdPolozkaMenu) {
        this.polozkaMenuByIdPolozkaMenu = polozkaMenuByIdPolozkaMenu;
    }
}
