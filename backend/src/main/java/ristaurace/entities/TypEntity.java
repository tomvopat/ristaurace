// Tomáš Vopat - vopattom

package ristaurace.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "typ", schema = "public", catalog = "ristaurace")
public class TypEntity {
    private int id;
    private String nazev;
    private Collection<TypPolozkaMenuEntity> typPolozkaMenusById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nazev")
    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypEntity typEntity = (TypEntity) o;
        return id == typEntity.id &&
                Objects.equals(nazev, typEntity.nazev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazev);
    }

    @OneToMany(mappedBy = "typByIdTyp")
    public Collection<TypPolozkaMenuEntity> getTypPolozkaMenusById() {
        return typPolozkaMenusById;
    }

    public void setTypPolozkaMenusById(Collection<TypPolozkaMenuEntity> typPolozkaMenusById) {
        this.typPolozkaMenusById = typPolozkaMenusById;
    }
}
