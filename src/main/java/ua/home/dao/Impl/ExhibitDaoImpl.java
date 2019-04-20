package ua.home.dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.home.dao.ExhibitDao;
import ua.home.entity.Exhibit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class ExhibitDaoImpl implements ExhibitDao {
    @Autowired
    EntityManagerFactory entityManagerFactory;
    @Override
    public boolean saveExhibit(Exhibit exhibit) {
        return false;
    }
    @Transactional
    @Override
    public List<Exhibit> readAllExhibits() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        return null;
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
