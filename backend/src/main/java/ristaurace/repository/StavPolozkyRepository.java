// Tomáš Vopat - vopattom

package ristaurace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.entities.StavPolozkyEntity;

public interface StavPolozkyRepository extends JpaRepository<StavPolozkyEntity, Integer> {
    @Override
    <S extends StavPolozkyEntity> S saveAndFlush(S s);
}
