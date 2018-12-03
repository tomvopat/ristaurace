// Tomáš Vopat - vopattom

package ristaurace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.entities.PolozkaMenuEntity;
import ristaurace.entities.TypPolozkaMenuEntity;

import java.util.List;
import java.util.Optional;

public interface PolozkaMenuRepository extends JpaRepository<PolozkaMenuEntity, Integer>, PolozkaMenuRepositoryCustom {
    @Override
    Optional<PolozkaMenuEntity> findById(Integer integer);

    @Override
    List<TypPolozkaMenuEntity> findAllByCategory(Integer category_id);
}
