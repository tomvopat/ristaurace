// Tomáš Vopat - vopattom

package ristaurace.dataLayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.dataLayer.entities.StavPolozkyEntity;

import java.util.List;
import java.util.Optional;

/**
 * Tato třída definuje rozhraní pro práci s databázovými objekty typu "StavPolozkyEntity"
 */
public interface StavPolozkyRepository extends JpaRepository<StavPolozkyEntity, Integer>, StavPolozkyRepositoryCustom {

    /**
     * Metoda pro uložení objektu do databáze.
     * @param s
     * @param <S>
     * @return
     */
    @Override
    <S extends StavPolozkyEntity> S saveAndFlush(S s);

    /**
     * Metoda vrátí list všech uložených položek.
     * @return
     */
    @Override
    List<StavPolozkyEntity> findAll();

    /**
     * Vrátí objekt se zadaným identifikátorem.
     * @param integer identifikátor
     * @return
     */
    @Override
    Optional<StavPolozkyEntity> findById(Integer integer);

    /**
     * Vrátí všechny objekty, které mají stav "otevřený".
     * @return
     */
    @Override
    List<StavPolozkyEntity> findAllPending();

    /**
     * Vrátí všechny položky, které mají stav "připravený".
     * @return
     */
    @Override
    List<StavPolozkyEntity> findAllReady();
}
