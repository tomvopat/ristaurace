// Tomáš Vopat - vopattom

package ristaurace.dataLayer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import ristaurace.dataLayer.entities.StulUcetEntity;
import ristaurace.dataLayer.helpObjects.StavEnum;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class StulUcetRepositoryImpl implements StulUcetRepositoryCustom {

    @Autowired
    StulUcetRepository stulUcetRepository;

    @PersistenceContext
    EntityManager entityManager;

    private List<StulUcetEntity> findAllWithState(StavEnum stav) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<StulUcetEntity> cq = cb.createQuery(StulUcetEntity.class);
        Root<StulUcetEntity> stulUcet = cq.from(StulUcetEntity.class);
        cq.where(cb.equal(stulUcet.get("stav"), stav));
        TypedQuery<StulUcetEntity> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<StulUcetEntity> findAllOpened() {
        return findAllWithState(StavEnum.otevreny);
    }

    @Override
    public List<StulUcetEntity> findAllClosed() {
        return findAllWithState(StavEnum.zavreny);
    }
}
