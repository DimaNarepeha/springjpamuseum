/*
 *Open source 2019
 */
package ua.home.dao.Impl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.home.dao.ExhibitDao;
import ua.home.entity.Exhibit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * connects to database and works with database through hibernate.
 */
@Repository
public class ExhibitDaoImpl implements ExhibitDao {
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean saveExhibit(Exhibit exhibit) {
        Session session = sessionFactory.getCurrentSession();
        session.save(exhibit);
        session.flush();
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
        Session sessionObj = sessionFactory.getCurrentSession();
        Exhibit exhibit = null;
        try {
            exhibit = (Exhibit) sessionObj.get(Exhibit.class, id);
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
            return null;
        }
        return exhibit;
    }

    @Override
    public int updateExhibit(Exhibit exhibit) {
        Session sessionObj = sessionFactory.getCurrentSession();
        try {
            sessionObj.update(exhibit);
        } catch (Exception sqlException) {
            return 0;
        }
        return 1;
    }


    @Override
    public int deleteExhibit(int id_exhibit) {
        Session sessionObj = sessionFactory.getCurrentSession();
        try {
            Exhibit exhibit = getExhibitById(id_exhibit);
            if (exhibit == null) return 0;
            sessionObj.delete(exhibit);
        } catch (Exception sqlException) {
            return 0;
        }
        return 1;
    }
}
