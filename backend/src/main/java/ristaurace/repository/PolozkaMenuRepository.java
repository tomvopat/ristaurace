// Tomáš Vopat - vopattom

package ristaurace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.entities.PolozkaMenuEntity;
import ristaurace.entities.TypPolozkaMenuEntity;

import java.util.List;

public interface PolozkaMenuRepository extends JpaRepository<PolozkaMenuEntity, Long>, PolozkaMenuRepositoryCustom {
    @Override
    List<PolozkaMenuEntity> findAllById(Iterable<Long> iterable);

    @Override
    List<TypPolozkaMenuEntity> findAllByCategory(Long category_id);
}
