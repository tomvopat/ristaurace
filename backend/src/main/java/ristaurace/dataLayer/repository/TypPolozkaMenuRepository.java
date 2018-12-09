// Tomáš Vopat - vopattom

package ristaurace.dataLayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.dataLayer.entities.TypPolozkaMenuEntity;

public interface TypPolozkaMenuRepository extends JpaRepository<TypPolozkaMenuEntity, Integer> {
}
