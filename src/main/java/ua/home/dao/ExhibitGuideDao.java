package ua.home.dao;


import ua.home.entity.Exhibit;
import ua.home.entity.Guide;


import java.util.HashSet;
import java.util.List;


public interface ExhibitGuideDao {
    public List<Guide> getGuidesByExhibitId(int id);

    public List<Exhibit> getExhibitsByGuideId(int id);

    public List<Guide> getGuidesThatAreNotInThisExhibitById(int id);

    public int reconnectRelations(HashSet<Integer> guidesToExhibit, int exhibitId);
}
