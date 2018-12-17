// Tomáš Vopat - vopattom

package ristaurace.dataLayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.dataLayer.entities.PopularitaEntity;

/**
 * Tato třída definuje rozhraní pro práci s databázovými objekty typu "PopularitaEntity"
 */
public interface PopularityRepository extends JpaRepository<PopularitaEntity, Integer> {
}
