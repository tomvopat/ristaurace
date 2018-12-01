// Tomáš Vopat - vopattom

package ristaurace.repository;

import ristaurace.entities.StavPolozkyEntity;
import ristaurace.entities.TypPolozkaMenuEntity;
import ristaurace.helpObjects.StavEnum;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class StavPolozkyRepositoryImpl implements StavPolozkyRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;


    public List<StavPolozkyEntity> findAllWithState(StavEnum stav) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<StavPolozkyEntity> cq = cb.createQuery(StavPolozkyEntity.class);
        Root<StavPolozkyEntity> stavPolozky = cq.from(StavPolozkyEntity.class);

        cq.where(cb.equal(stavPolozky.get("stav"), stav));
        TypedQuery<StavPolozkyEntity>  typedQuery = entityManager.createQuery(cq);
        return typedQuery.getResultList();
    }

    @Override
    public List<StavPolozkyEntity> findAllPending() {
        return findAllWithState(StavEnum.otevreny);
    }

    @Override
    public List<StavPolozkyEntity> findAllReady() {
        return findAllWithState(StavEnum.pripraveny);
    }

    @Override
    public List<StavPolozkyEntity> findAllClosed() {
        return findAllWithState(StavEnum.zavreny);
    }
}
