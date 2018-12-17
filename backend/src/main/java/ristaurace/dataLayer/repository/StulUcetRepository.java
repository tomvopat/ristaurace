// Tomáš Vopat - vopattom

package ristaurace.dataLayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.dataLayer.entities.StulUcetEntity;

import java.util.List;

public interface StulUcetRepository extends JpaRepository<StulUcetEntity, Integer>, StulUcetRepositoryCustom {
    @Override
    List<StulUcetEntity> findAllOpened();

    @Override
    List<StulUcetEntity> findAll();
}