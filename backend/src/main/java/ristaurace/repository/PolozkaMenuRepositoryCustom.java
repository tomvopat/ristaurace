// Tomáš Vopat - vopattom

package ristaurace.repository;

import ristaurace.entities.PolozkaMenuEntity;
import ristaurace.entities.TypPolozkaMenuEntity;

import java.util.List;

public interface PolozkaMenuRepositoryCustom {

    /**
     * Vrátí všechny TypPolozkaMenuEntity podle zvolené kategorie
     * @param category_id
     * @return
     */
    List<TypPolozkaMenuEntity> findAllByCategory(Integer category_id);
}
