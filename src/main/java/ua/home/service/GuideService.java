package ua.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.home.entity.Guide;
import ua.home.repository.GuideRepository;

import java.util.List;
@Service
public class GuideService {
    @Autowired
    GuideRepository guideRepository;
    public List<Guide> findAllGuides(){
/*
        Guide guide = new Guide();
        guide.setId(1);
        guide.setFirstName("Nastia");
        guide.setLastName("Nastia");
        guideRepository.save(guide);*/
        return guideRepository.findAll();
    }
    public void saveGuides(Guide guide){

        guideRepository.save(guide);
    }
    public void deleteGuides(int guide){
        guideRepository.deleteById(guide);
    }

    public void updateGuides(Guide guide){
        if(!guideRepository.existsById(guide.getId()))return;
        Guide guide1 = guideRepository.getGuideById(guide.getId());
       // guideRepository.deleteById(guide.getId());
        guide1.setFirstName(guide.getFirstName());
        guide1.setLastName(guide.getLastName());
        guideRepository.save(guide1);
    }
}
