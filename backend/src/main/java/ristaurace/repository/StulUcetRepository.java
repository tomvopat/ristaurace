// Tomáš Vopat - vopattom

package ristaurace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.entities.StulUcetEntity;

import java.util.List;

public interface StulUcetRepository extends JpaRepository<StulUcetEntity, Long>, StulUcetRepositoryCustom {
    @Override
    List<StulUcetEntity> findAllOpened();

    @Override
    List<StulUcetEntity> findAll();
}
