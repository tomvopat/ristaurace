// Tomáš Vopat - vopattom

package ristaurace.dataLayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.dataLayer.entities.PolozkaMenuEntity;
import ristaurace.dataLayer.entities.TypPolozkaMenuEntity;

import java.util.List;
import java.util.Optional;

public interface PolozkaMenuRepository extends JpaRepository<PolozkaMenuEntity, Integer>, PolozkaMenuRepositoryCustom {
    @Override
    Optional<PolozkaMenuEntity> findById(Integer integer);

    @Override
    List<TypPolozkaMenuEntity> findAllByCategory(Integer category_id);
}
