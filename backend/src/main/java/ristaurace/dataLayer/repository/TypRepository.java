// Tomáš Vopat - vopattom

package ristaurace.dataLayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.dataLayer.entities.TypEntity;

import java.util.List;

/**
 * Tato třída definuje rozhraní pro práci s databázovými objekty typu "TypEntity"
 */
public interface TypRepository extends JpaRepository<TypEntity, Integer> {

    /**
     * Vrátí všechny uložené položky.
     * @return
     */
    @Override
    List<TypEntity> findAll();
}
