// Tomáš Vopat - vopattom

package ristaurace.repository;

import org.springframework.beans.factory.annotation.Autowired;
import ristaurace.entities.StulUcetEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class StulUcetRepositoryImpl implements StulUcetRepositoryCustom {

    @Autowired
    StulUcetRepository stulUcetRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<StulUcetEntity> findAllOpened() {
        //TODO
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<StulUcetEntity> cq = cb.createQuery(StulUcetEntity.class);
//        Root<StulUcetEntity> stulUcet = cq.from(StulUcetEntity.class);
//        cq.where(cb.equal(stulUcet.get("stav"), 1));
//        TypedQuery<StulUcetEntity> query = entityManager.createQuery(cq);
//        return query.getResultList();

        return stulUcetRepository.findAll();
    }
}
