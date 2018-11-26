// Tomáš Vopat - vopattom

package cz.cvut.fit.si.ristaurace.model;

import javax.persistence.*;

@Entity
public class Polozka_menu {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "menu_sequence")
    @SequenceGenerator(name = "menu_sequence", sequenceName = "SEQ_Menu_MenuID")
    @Column(name = "Polozka_menuID")
    private Long id;

    @Column(name = "Nazev")
    private String jazyk;

    @Column(name = "Cena")
    private Float cena;

//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "team_id", nullable = false)
//    private Team team;

    public Polozka_menu() {
    }
}
