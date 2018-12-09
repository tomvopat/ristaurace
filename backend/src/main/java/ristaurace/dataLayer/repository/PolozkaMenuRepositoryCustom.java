// Tomáš Vopat - vopattom

package ristaurace.dataLayer.repository;

import ristaurace.dataLayer.entities.TypPolozkaMenuEntity;

import java.util.List;

public interface PolozkaMenuRepositoryCustom {

    /**
     * Vrátí všechny TypPolozkaMenuEntity podle zvolené kategorie
     * @param category_id
     * @return
     */
    List<TypPolozkaMenuEntity> findAllByCategory(Integer category_id);
}
