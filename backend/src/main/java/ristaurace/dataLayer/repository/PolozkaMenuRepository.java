// Tomáš Vopat - vopattom

package ristaurace.dataLayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.dataLayer.entities.PolozkaMenuEntity;
import ristaurace.dataLayer.entities.TypPolozkaMenuEntity;

import java.util.List;
import java.util.Optional;

/**
 * Tato třída definuje rozhraní pro práci s databázovými objekty typu "PolozkaMenuEntity"
 */
public interface PolozkaMenuRepository extends JpaRepository<PolozkaMenuEntity, Integer>, PolozkaMenuRepositoryCustom {

    /**
     * Vrátí položku se zadaným identifikátorem.
     * @param integer
     * @return
     */
    @Override
    Optional<PolozkaMenuEntity> findById(Integer integer);

    /**
     * Vrátí vššchny položky v zadané kategorii (s daným typem).
     * @param category_id identifikátor typu
     * @return
     */
    @Override
    List<TypPolozkaMenuEntity> findAllByCategory(Integer category_id);
}
