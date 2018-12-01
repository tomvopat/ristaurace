// Tomáš Vopat - vopattom

package ristaurace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.entities.TypEntity;

import java.util.List;

public interface TypRepository extends JpaRepository<TypEntity, Long> {
    @Override
    List<TypEntity> findAll();
}
