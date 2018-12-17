// Tomáš Vopat - vopattom

package ristaurace.dataLayer.repository;

import ristaurace.dataLayer.entities.StavPolozkyEntity;
import ristaurace.dataLayer.entities.UcetEntity;
import ristaurace.dataLayer.helpObjects.StavEnum;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Tato třída implementuje rozhraní definované v tříde "StavPolozkyRepositoryCustom" pro práci se stavem položky menu
 */
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
    public List<StavPolozkyEntity> findAllWithBill(Integer billId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<StavPolozkyEntity> cq = cb.createQuery(StavPolozkyEntity.class);
        Root<StavPolozkyEntity> stav = cq.from(StavPolozkyEntity.class);

        Join<StavPolozkyEntity, UcetEntity> stavUcet = stav.join("ucetByIdUcet");

        cq.where(cb.equal(stavUcet.get("id"), billId));
        TypedQuery<StavPolozkyEntity> q = entityManager.createQuery(cq);
        return q.getResultList();
    }
}
