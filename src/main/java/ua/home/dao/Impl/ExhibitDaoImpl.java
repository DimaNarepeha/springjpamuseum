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
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ExhibitDaoImpl implements ExhibitDao {
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean saveExhibit(Exhibit exhibit) {
        Session session = sessionFactory.getCurrentSession();
//        entityManager.getTransaction().begin();

        session.save(exhibit);
        session.flush();
//        entityManager.getTransaction().commit();
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
        return 0;
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
