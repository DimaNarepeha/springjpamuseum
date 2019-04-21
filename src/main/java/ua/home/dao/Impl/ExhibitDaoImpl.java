package ua.home.dao.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.home.dao.ExhibitDao;
import ua.home.entity.Exhibit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository

public class ExhibitDaoImpl implements ExhibitDao {
    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    @Transactional
    public boolean saveExhibit(Exhibit exhibit) {
        System.out.println("inside saveExhibit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(exhibit);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public List<Exhibit> readAllExhibits() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaQuery getAll = entityManager.getCriteriaBuilder().createQuery(Exhibit.class);
        getAll.select(getAll.from(Exhibit.class));
        entityManager.createQuery(getAll).getResultList();
        return entityManager.createQuery(getAll).getResultList();
    }

    @Override
    public Exhibit getExhibitById(int id) {
        return null;
    }

    @Override
    public int updateExhibit(Exhibit exhibit) {
        return 0;
    }

    @Override
    public int deleteExhibit(int id_exhibit) {
        return 0;
    }
}
