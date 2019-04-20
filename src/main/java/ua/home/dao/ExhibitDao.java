package ua.home.dao;



import ua.home.entity.Exhibit;

import java.util.List;

public interface ExhibitDao {
    boolean saveExhibit(Exhibit exhibit);

    List<Exhibit> readAllExhibits();

    Exhibit getExhibitById(int id);

    int updateExhibit(Exhibit exhibit);

    int deleteExhibit(int id_exhibit);

}
