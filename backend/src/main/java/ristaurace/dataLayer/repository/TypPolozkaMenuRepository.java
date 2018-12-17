// Tomáš Vopat - vopattom

package ristaurace.dataLayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.dataLayer.entities.TypPolozkaMenuEntity;

/**
 * Tato třída definuje rozhraní pro práci s databázovými objekty typu "TypPolozkaMenuEntity"
 */
public interface TypPolozkaMenuRepository extends JpaRepository<TypPolozkaMenuEntity, Integer> {
}
