// Tomáš Vopat - vopattom

package ristaurace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.entities.StavPolozkyEntity;

import java.util.List;
import java.util.Optional;

public interface StavPolozkyRepository extends JpaRepository<StavPolozkyEntity, Integer>, StavPolozkyRepositoryCustom {
    @Override
    <S extends StavPolozkyEntity> S saveAndFlush(S s);

    @Override
    List<StavPolozkyEntity> findAll();

    @Override
    Optional<StavPolozkyEntity> findById(Integer integer);

    @Override
    List<StavPolozkyEntity> findAllPending();

    @Override
    List<StavPolozkyEntity> findAllReady();
}
