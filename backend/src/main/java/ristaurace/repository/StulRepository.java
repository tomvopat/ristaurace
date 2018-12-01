// Tomáš Vopat - vopattom

package ristaurace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.entities.StulEntity;

import java.util.List;

public interface StulRepository extends JpaRepository<StulEntity, Long> {
    List<StulEntity> findAll();
}
