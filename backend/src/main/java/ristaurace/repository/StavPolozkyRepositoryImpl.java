// Tomáš Vopat - vopattom

package ristaurace.repository;

import ristaurace.entities.StavPolozkyEntity;
import ristaurace.entities.TypPolozkaMenuEntity;
import ristaurace.entities.UcetEntity;
import ristaurace.helpObjects.StavEnum;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
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

    @Override
    public List<StavPolozkyEntity> findAllWithBill(Integer bill_id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<StavPolozkyEntity> cq = cb.createQuery(StavPolozkyEntity.class);
        Root<StavPolozkyEntity> stav = cq.from(StavPolozkyEntity.class);

        Join<StavPolozkyEntity, UcetEntity> stavUcet = stav.join("ucetByIdUcet");

        cq.where(cb.equal(stavUcet.get("id"), bill_id));
        TypedQuery<StavPolozkyEntity> q = entityManager.createQuery(cq);
        return q.getResultList();
    }
}
