package ua.home.dao.Impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.home.dao.GuideDAO;
import ua.home.entity.Guide;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public class GuideDAOImpl implements GuideDAO {
    //static Session sessionObj;
    @Autowired
    private SessionFactory sessionFactory;
    public  Guide save(Guide guide) {
        Session sessionObj = sessionFactory.getCurrentSession();
        try {
            sessionObj.save(guide);
            sessionObj.flush();
            return guide;
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public  List<Guide> findAll() {
        Session sessionObj = sessionFactory.getCurrentSession();
        List<Guide> list = null;
        try {
            CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
            CriteriaQuery<Guide> query = builder.createQuery(Guide.class);
            Root<Guide> root = query.from(Guide.class);
            query.select(root);
            Query<Guide> q = sessionObj.createQuery(query);
            list = q.getResultList();

        } catch(Exception sqlException) {
            sqlException.printStackTrace();
            return null;
        }
        return list;
    }
    @Transactional

    public Guide update(Guide guide) {
        Session sessionObj = sessionFactory.getCurrentSession();
        try {
            Guide depObj = (Guide) sessionObj.get(Guide.class, guide.getId());
            if(depObj==null)return null;
            depObj.setFirstName(guide.getFirstName());
            depObj.setLastName(guide.getLastName());

        } catch(Exception sqlException) {
            sqlException.printStackTrace();
        }
        return guide;
    }

    public Guide deleteById(Integer guide_id) {
        Session sessionObj = sessionFactory.getCurrentSession();
        try {
            Guide depObj = findById(guide_id);
            if(depObj==null||guide_id<=5)return null;
            sessionObj.delete(depObj);
            return depObj;
        } catch(Exception sqlException) {
            return null;
        }

    }


    public Guide findById(Integer find_department_id) {
        Session sessionObj = sessionFactory.getCurrentSession();
        Guide findDepartmentObj = null;
        try {
            findDepartmentObj = (Guide) sessionObj.get(Guide.class, find_department_id);
            if(findDepartmentObj==null)return null;
        } catch(Exception sqlException) {
            sqlException.printStackTrace();
            return null;
        }
        return findDepartmentObj;
    }



}
