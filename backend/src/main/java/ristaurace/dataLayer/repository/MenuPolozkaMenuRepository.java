// Tomáš Vopat - vopattom

package ristaurace.dataLayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.dataLayer.entities.MenuPolozkaMenuEntity;

/**
 * Tato třída definuje rozhraní pro práci s databázovými objekty typu "MenuPolozkaMenuEntity"
 */
public interface MenuPolozkaMenuRepository extends JpaRepository<MenuPolozkaMenuEntity, Integer> {

}
