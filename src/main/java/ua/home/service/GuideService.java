package ua.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.home.dao.GuideDAO;
import ua.home.entity.Guide;
import ua.home.repository.GuideRepository;

import java.util.List;
@Service
public class GuideService {
    @Autowired
    GuideDAO guideDAO;
    public List<Guide> findAllGuides(){
/*
        Guide guide = new Guide();
        guide.setId(1);
        guide.setFirstName("Nastia");
        guide.setLastName("Nastia");
        guideRepository.save(guide);*/
        return guideDAO.findAll();
    }
    public void saveGuides(Guide guide){

        guideDAO.save(guide);
    }
    public void deleteGuides(int guide){
        guideDAO.deleteById(guide);
    }

    public void updateGuides(Guide guide){
       guideDAO.update(guide);
    }
}
