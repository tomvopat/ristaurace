// Tomáš Vopat - vopattom

package ristaurace.repository;

import ristaurace.entities.StulUcetEntity;

import java.util.List;

public interface StulUcetRepositoryCustom {
    List<StulUcetEntity> findAllOpened();
}
