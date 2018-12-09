// Tomáš Vopat - vopattom

package ristaurace.dataLayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.dataLayer.entities.StulEntity;

import java.util.List;

public interface StulRepository extends JpaRepository<StulEntity, Integer> {
    List<StulEntity> findAll();
}
