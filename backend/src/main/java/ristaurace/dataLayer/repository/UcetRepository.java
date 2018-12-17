// Tomáš Vopat - vopattom

package ristaurace.dataLayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.dataLayer.entities.UcetEntity;

import java.util.List;
import java.util.Optional;

/**
 * Tato třída definuje rozhraní pro práci s databázovými objekty typu "UcetEntity".
 */
public interface UcetRepository extends JpaRepository<UcetEntity, Integer> {

    /**
     * Vrátí všechny položky podle zadaného identifikátoru.
     * @param integer
     * @return
     */
    @Override
    Optional<UcetEntity> findById(Integer integer);

    /**
     * Vrátí všechny uložené položky.
     * @return
     */
    @Override
    List<UcetEntity> findAll();
}
