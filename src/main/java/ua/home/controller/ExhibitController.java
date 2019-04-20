package ua.home.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.home.dao.ExhibitDao;

import javax.jws.WebParam;

@Controller
public class ExhibitController {
@Autowired
    ExhibitDao exhibitDao;

    @GetMapping("/addExhibit")
    public ModelAndView addExhibit(){
        ModelAndView modelAndView=new ModelAndView("addExhibit");
        return modelAndView; //TODO add implementation to addExhibit
    }

    @GetMapping("/listExhibit")
    public ModelAndView listExhibit(){
        ModelAndView modelAndView=new ModelAndView("listExhibit");
        modelAndView.addObject("exhibits",exhibitDao.readAllExhibits());
        return modelAndView;
    }
}
