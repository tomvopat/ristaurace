// Tomáš Vopat - vopattom

package ristaurace.dataLayer.repository;

import ristaurace.dataLayer.entities.TypPolozkaMenuEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Tato třída implementuje rozhraní definované v tříde "PolozkaMenuRepositoryCustom" pro práci s pložkami menu
 */
public class PolozkaMenuRepositoryImpl implements PolozkaMenuRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<TypPolozkaMenuEntity> findAllByCategory(Integer categoryId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<TypPolozkaMenuEntity> cq = cb.createQuery(TypPolozkaMenuEntity.class);
        Root<TypPolozkaMenuEntity> polozka = cq.from(TypPolozkaMenuEntity.class);
        cq.where(cb.equal(polozka.get("typByIdTyp"), categoryId));

        TypedQuery<TypPolozkaMenuEntity> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
