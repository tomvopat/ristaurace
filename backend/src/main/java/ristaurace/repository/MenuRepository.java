// Tomáš Vopat - vopattom

package ristaurace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.entities.MenuEntity;

public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {

}
