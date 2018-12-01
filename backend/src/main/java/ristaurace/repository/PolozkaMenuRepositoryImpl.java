// Tomáš Vopat - vopattom

package ristaurace.repository;

import org.springframework.beans.factory.annotation.Autowired;
import ristaurace.entities.PolozkaMenuEntity;
import ristaurace.entities.TypEntity;
import ristaurace.entities.TypPolozkaMenuEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.List;

public class PolozkaMenuRepositoryImpl implements PolozkaMenuRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<TypPolozkaMenuEntity> findAllByCategory(Long category_id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<TypPolozkaMenuEntity> cq = cb.createQuery(TypPolozkaMenuEntity.class);
        Root<TypPolozkaMenuEntity> polozka = cq.from(TypPolozkaMenuEntity.class);
        cq.where(cb.equal(polozka.get("typByIdTyp"), category_id));

        TypedQuery<TypPolozkaMenuEntity> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
