// Tomáš Vopat - vopattom

package ristaurace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.entities.StulEntity;

import java.util.List;

public interface StulRepository extends JpaRepository<StulEntity, Integer> {
    List<StulEntity> findAll();
}
