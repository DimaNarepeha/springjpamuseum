package ua.home.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import ua.home.dao.ExhibitDao;
import ua.home.entity.Exhibit;

import static ua.home.Util.ExhibitUtil.checkIfNoEmptyFieldsIn;
import static ua.home.Util.ExhibitUtil.getExhibitFromString;


@Controller
public class ExhibitController {
    @Autowired
    ExhibitDao exhibitDao;

    @GetMapping("/addExhibit")
    public ModelAndView addExhibitPage() {
        ModelAndView modelAndView = new ModelAndView("addExhibit");
        modelAndView.addObject("exhibits", exhibitDao.readAllExhibits());
        return modelAndView; //TODO add implementation to addExhibit
    }

    @PostMapping("/addExhibit")
    public ModelAndView addExhibitToDb(@RequestBody String json) {
        Exhibit exhibit =getExhibitFromString(json);
        ModelAndView modelAndView = new ModelAndView("addExhibit");
        modelAndView.addObject("exhibits", exhibitDao.readAllExhibits());
        if(!checkIfNoEmptyFieldsIn(exhibit)){
            modelAndView.addObject("success",0);
            return modelAndView;
        }
        exhibitDao.saveExhibit(exhibit);
        modelAndView.addObject("success",1);
        System.out.println(exhibit);
        return modelAndView;
    }

    @GetMapping("/listExhibit")
    public ModelAndView listExhibit() {
        ModelAndView modelAndView = new ModelAndView("listExhibit");
        modelAndView.addObject("exhibits", exhibitDao.readAllExhibits());
        return modelAndView;
    }


}
