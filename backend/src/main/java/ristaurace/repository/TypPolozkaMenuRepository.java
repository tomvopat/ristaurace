// Tomáš Vopat - vopattom

package ristaurace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.entities.TypPolozkaMenuEntity;

public interface TypPolozkaMenuRepository extends JpaRepository<TypPolozkaMenuEntity, Integer> {
}
