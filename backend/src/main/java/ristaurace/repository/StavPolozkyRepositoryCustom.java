// Tomáš Vopat - vopattom

package ristaurace.repository;

import ristaurace.entities.StavPolozkyEntity;

import java.util.List;

public interface StavPolozkyRepositoryCustom {

    List<StavPolozkyEntity> findAllPending();

    List<StavPolozkyEntity> findAllReady();

    List<StavPolozkyEntity> findAllClosed();

}
