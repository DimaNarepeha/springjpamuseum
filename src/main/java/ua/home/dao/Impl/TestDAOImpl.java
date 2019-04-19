package ua.home.dao.Impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import ua.home.dao.TestDAO;
import ua.home.entity.Test;

import javax.transaction.Transactional;

@Transactional
@Repository
public class TestDAOImpl implements TestDAO {
    @Override
    public void save() {
      /*  Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        // Getting Transaction Object From Session Object
        Test t = new Test();
        t.setNumber(3);
        sessionObj.save(t);
        sessionObj.beginTransaction();*/

    }
}
