// Tomáš Vopat - vopattom

package ristaurace.dataLayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.dataLayer.entities.UcetEntity;

import java.util.List;
import java.util.Optional;

public interface UcetRepository extends JpaRepository<UcetEntity, Integer> {
    @Override
    Optional<UcetEntity> findById(Integer integer);

    @Override
    List<UcetEntity> findAll();
}
