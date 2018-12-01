// Tomáš Vopat - vopattom

package ristaurace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.entities.UcetEntity;

import java.util.List;
import java.util.Optional;

public interface UcetRepository extends JpaRepository<UcetEntity, Long> {
    @Override
    Optional<UcetEntity> findById(Long aLong);

    @Override
    List<UcetEntity> findAll();
}
