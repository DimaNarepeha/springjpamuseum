package ua.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.home.dao.GuideDAO;
import ua.home.entity.Guide;
import ua.home.exception.NotFoundException;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GuideService {
    @Autowired
    GuideDAO guideDAO;

    public List<Guide> findAllGuides() {
        return guideDAO.findAll();
    }

    public void saveGuides(Guide guide) {
        guideDAO.save(guide);
    }

    public boolean deleteGuides(int guide) {
        if (guideDAO.deleteById(guide) != null) return true;
        else throw new NotFoundException("Hello");
    }

    public Guide findGuideById(Integer id) {
        return guideDAO.findById(id);
    }

    public boolean updateGuides(Guide guide) {
        if (guide.getFirstName().equals("") || guide.getLastName().equals("")) return false;
        if (guideDAO.update(guide) == null) return false;
        else return true;
    }

    public Map<String, List<String>> getGuideExhibit() {
        return guideDAO.getGuidesByExhibit();
    }
}
