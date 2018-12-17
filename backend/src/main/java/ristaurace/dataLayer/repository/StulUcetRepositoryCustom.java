// Tomáš Vopat - vopattom

package ristaurace.dataLayer.repository;

import ristaurace.dataLayer.entities.StulUcetEntity;

import java.util.List;


public interface StulUcetRepositoryCustom {
    /**
     * Vrátí všechny položky se stavem otevřeno
     * @return
     */
    List<StulUcetEntity> findAllOpened();

    /**
     * Vrátí všechny položky se stavem zavřeno
     * @return
     */
    List<StulUcetEntity> findAllClosed();
}
