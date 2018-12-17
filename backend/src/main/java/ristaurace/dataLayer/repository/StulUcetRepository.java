// Tomáš Vopat - vopattom

package ristaurace.dataLayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.dataLayer.entities.StulUcetEntity;

import java.util.List;

/**
 * Tato třída definuje rozhraní pro práci s databázovými objekty typu "StulUcetEntity"
 */
public interface StulUcetRepository extends JpaRepository<StulUcetEntity, Integer>, StulUcetRepositoryCustom {

    /**
     * Vrátí všechny položky se stavem "otevřený".
     * @return
     */
    @Override
    List<StulUcetEntity> findAllOpened();

    /**
     * Vrátí všechny uložené položky.
     * @return
     */
    @Override
    List<StulUcetEntity> findAll();
}
