package ua.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.home.dao.ExhibitDao;
import ua.home.entity.Exhibit;

import java.util.List;

@Service
public class ExhibitService{
    @Autowired
    ExhibitDao exhibitDao;

    public boolean saveExhibit(Exhibit exhibit) {
        exhibitDao.saveExhibit(exhibit);
        return true;
    }


    public List<Exhibit> readAllExhibits() {
        return exhibitDao.readAllExhibits();
    }


    public Exhibit getExhibitById(int id){
       return exhibitDao.getExhibitById(id);
    }


    public int updateExhibit(Exhibit exhibit) {
       return exhibitDao.updateExhibit(exhibit);
    }


    public int deleteExhibit(int id_exhibit) {
       return exhibitDao.deleteExhibit(id_exhibit);
    }
}
