// Tomáš Vopat - vopattom

package ristaurace.dataLayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.dataLayer.entities.MenuEntity;

/**
 * Tato třída definuje rozhraní pro práci s databázovými objekty typu "MenuEntity"
 */
public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {

}
