// Tomáš Vopat - vopattom

package ristaurace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.entities.PolozkaMenuEntity;

import java.util.List;
import java.util.Optional;

public interface PolozkaMenuRepository extends JpaRepository<PolozkaMenuEntity, Long> {
    Optional<PolozkaMenuEntity> findById(Long aLong);
}
