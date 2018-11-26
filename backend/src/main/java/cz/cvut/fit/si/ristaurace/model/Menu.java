// Tomáš Vopat - vopattom

package cz.cvut.fit.si.ristaurace.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "menu_sequence")
    @SequenceGenerator(name = "menu_sequence", sequenceName = "SEQ_Menu_MenuID")
    @Column(name = "MenuID")
    private Long id;

    @Column(name = "Jazyk")
    private String jazyk;

    @Column(name = "Platne_od")
    private LocalDate platne_od;

    @Column(name = "Platne_do")
    private LocalDate platne_do;

//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "team_id", nullable = false)
//    private Team team;

    public Menu() {
    }
}
