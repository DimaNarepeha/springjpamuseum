package ua.home.dao.Impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.home.dao.GuideDAO;
import ua.home.entity.Guide;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

   public Map<String, List<String>> getGuidesByExhibit(){
       Session session = sessionFactory.getCurrentSession();
       Map<String,List<String>> map = new HashMap<>();
       List<String> guides = new ArrayList<>();
       List<Object[]> employees = session.createNativeQuery(
               "select g.lastname,e.exhibit_name from exhibit_guide eg join guide g on g.id_guide = eg.id_guide join exhibit e on e.id_exhibit = eg.id_exhibit;"

               ).addScalar("lastname", StringType.INSTANCE)
               .addScalar( "exhibit_name", StringType.INSTANCE )
               .list();

       for (Object[] objects : employees) {
           String name=(String)objects[0];
           String exhibit =(String)objects[1];
           if(map.keySet().contains(exhibit))map.get(exhibit).add(name);
           else{
               List<String> array = new ArrayList();
               array.add(name);
               map.put(exhibit,array);}
       }
       return map;
   }


}
