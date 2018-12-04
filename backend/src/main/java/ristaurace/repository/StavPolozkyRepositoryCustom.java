// Tomáš Vopat - vopattom

package ristaurace.repository;

import ristaurace.entities.StavPolozkyEntity;

import java.util.List;

public interface StavPolozkyRepositoryCustom {

    /**
     * Vrátí všechny položky se stavem otevreny
     * @return
     */
    List<StavPolozkyEntity> findAllPending();

    /**
     * Vrátí všechny položky se staven pripraveny
     * @return
     */
    List<StavPolozkyEntity> findAllReady();

    /**
     * Vrátí všechny položky se stavem uzavřený
     * @return
     */
    List<StavPolozkyEntity> findAllClosed();

    /**
     * Vrátí všechny položky z daného účtu
     * @param bill_id
     * @return
     */
    List<StavPolozkyEntity> findAllWithBill(Integer bill_id);

}
