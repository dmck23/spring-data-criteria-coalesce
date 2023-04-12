package com.example.spring_data_rounding.repositories;

import com.example.spring_data_rounding.entities.TestTable;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
@RequiredArgsConstructor
public class CriteriaRepository {

    private final EntityManager em;


    public BigDecimal getSummedValue() {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<BigDecimal> cq = cb.createQuery(BigDecimal.class);

        Root<TestTable> root  = cq.from(TestTable.class);

        cq.select(cb.sum(root.get("value")));

        return em.createQuery(cq).getSingleResult();
    }

    public BigDecimal getCoalesceSummedValue() {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<BigDecimal> cq = cb.createQuery(BigDecimal.class);

        Root<TestTable> root  = cq.from(TestTable.class);

        cq.select(cb.coalesce(cb.sum(root.get("value")), BigDecimal.valueOf(0.0000000000)));

        return em.createQuery(cq).getSingleResult();
    }
}
