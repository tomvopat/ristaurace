// Tomáš Vopat - vopattom

package ristaurace.repository;

import ristaurace.entities.PolozkaMenuEntity;
import ristaurace.entities.TypPolozkaMenuEntity;

import java.util.List;

public interface PolozkaMenuRepositoryCustom {
    List<TypPolozkaMenuEntity> findAllByCategory(Integer category_id);
}
