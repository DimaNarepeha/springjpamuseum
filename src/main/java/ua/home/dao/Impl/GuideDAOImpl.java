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

    // Method 1: This Method Used To Create A New Worker Record In The Database Table

    public  Integer save(Guide guide) {
        Session sessionObj = sessionFactory.getCurrentSession();
        try {

            // Getting Session Object From SessionFactory
            //sessionObj = HibernateUtil.getSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            //sessionObj.beginTransaction();
            sessionObj.save(guide);
            sessionObj.flush();
         //   sessionObj.getTransaction().commit();
            System.out.println("\nSuccessfully Created  Records In The Database!\n");
        } catch (Exception sqlException) {
         /*   if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }*/
            sqlException.printStackTrace();
        } finally {
          /*  if (sessionObj != null) {
                sessionObj.close();
            }*/
        }
        return 1;
    }

    // Method 2: This Method Is Used To Display The Records From The Database Table
    @SuppressWarnings("unchecked")
    @Transactional
    public  List<Guide> findAll() {
        Session sessionObj = sessionFactory.getCurrentSession();
        //sessionObj.beginTransaction();
        List<Guide> list = null;
        try {
            // Getting Session Object From SessionFactory
           // sessionObj = HibernateUtil.getSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            //sessionObj.beginTransaction();
            CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
            CriteriaQuery<Guide> query = builder.createQuery(Guide.class);
            Root<Guide> root = query.from(Guide.class);
            query.select(root);
            Query<Guide> q = sessionObj.createQuery(query);
            list = q.getResultList();

        } catch(Exception sqlException) {
           /* if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }*/
            sqlException.printStackTrace();
        } finally {
         /*   if(sessionObj != null) {
                sessionObj.close();
            }*/
        }
        return list;
    }
    @Transactional
    // Method 3: This Method Is Used To Update A Record In The Database Table
    public Guide update(Guide guide) {
        Session sessionObj = sessionFactory.getCurrentSession();
        try {
            // Getting Session Object From SessionFactory
         //   sessionObj = HibernateUtil.getSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            //sessionObj.beginTransaction();

            // Creating Transaction Entity
            Guide depObj = (Guide) sessionObj.get(Guide.class, guide.getId());
            depObj.setFirstName(guide.getFirstName());
            depObj.setLastName(guide.getLastName());


            // Committing The Transactions To The Database
          //  sessionObj.getTransaction().commit();
           // System.out.println("\nDepartment With Id?= " + department_id + " Is Successfully Updated In The Database!\n");
        } catch(Exception sqlException) {
          /*  if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }*/
            sqlException.printStackTrace();
        } finally {
          /*  if(sessionObj != null) {
                sessionObj.close();
            }*/
        }
        return guide;
    }

    // Method 4(a): This Method Is Used To Delete A Particular Record From The Database Table
    public  void deleteById(Integer guide_id) {
        Session sessionObj = sessionFactory.getCurrentSession();
        try {
            // Getting Session Object From SessionFactory
          //  sessionObj = HibernateUtil.getSessionFactory().openSession();
            // Getting Transaction Object From Session Object
           // sessionObj.beginTransaction();

            Guide depObj = findById(guide_id);
            sessionObj.delete(depObj);

            // Committing The Transactions To The Database
          //  sessionObj.getTransaction().commit();
            //System.out.println("\nDepartment With Id?= " + department_id + " Is Successfully Deleted From The Database!\n");
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
          /*  if(sessionObj != null) {
                sessionObj.close();
            }*/
        }
    }

    // Method 4(b): This Method To Find Particular Record In The Database Table
    public Guide findById(Integer find_department_id) {
        Session sessionObj = sessionFactory.getCurrentSession();
        Guide findDepartmentObj = null;
        try {
            // Getting Session Object From SessionFactory
          //  sessionObj = HibernateUtil.getSessionFactory().openSession();
            // Getting Transaction Object From Session Object
        //    sessionObj.beginTransaction();

            findDepartmentObj = (Guide) sessionObj.load(Guide.class, find_department_id);
        } catch(Exception sqlException) {
         /*   if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }*/
            sqlException.printStackTrace();
        }
        return findDepartmentObj;
    }
    //}


}
