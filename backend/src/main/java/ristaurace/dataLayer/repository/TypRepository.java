// Tomáš Vopat - vopattom

package ristaurace.dataLayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.dataLayer.entities.TypEntity;

import java.util.List;

public interface TypRepository extends JpaRepository<TypEntity, Integer> {
    @Override
    List<TypEntity> findAll();
}
