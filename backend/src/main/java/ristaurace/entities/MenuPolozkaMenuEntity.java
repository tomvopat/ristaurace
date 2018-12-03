// Tomáš Vopat - vopattom

package ristaurace.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "menu_polozka_menu", schema = "public", catalog = "ristaurace")
public class MenuPolozkaMenuEntity {
    private int id;
    private MenuEntity menuByIdMenu;
    private PolozkaMenuEntity polozkaMenuByIdPolozkaMenu;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuPolozkaMenuEntity that = (MenuPolozkaMenuEntity) o;
        return id == that.id &&
                menuByIdMenu.getId() == that.menuByIdMenu.getId() &&
                polozkaMenuByIdPolozkaMenu.getId() == that.polozkaMenuByIdPolozkaMenu.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, menuByIdMenu.getId(), polozkaMenuByIdPolozkaMenu.getId());
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
