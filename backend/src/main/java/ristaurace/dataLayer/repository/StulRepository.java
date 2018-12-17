// Tomáš Vopat - vopattom

package ristaurace.dataLayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.dataLayer.entities.StulEntity;

import java.util.List;

/**
 * Tato třída definuje rozhraní pro práci s databázovými objekty typu "StulEntity"
 */
public interface StulRepository extends JpaRepository<StulEntity, Integer> {

    /**
     * Vrátí všechny uložené položky.
     * @return
     */
    @Override
    List<StulEntity> findAll();
}
