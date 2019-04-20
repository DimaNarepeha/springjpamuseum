package ua.home.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
public class ExhibitController {


    @GetMapping("/addExhibit")
    public ModelAndView addExhibit(){
        ModelAndView modelAndView=new ModelAndView("addExhibit");
        return modelAndView; //TODO add implementation to addExhibit
    }

    @GetMapping("/listExhibit")
    public ModelAndView listExhibit(){
        ModelAndView modelAndView=new ModelAndView("listExhibit");
        modelAndView.addObject("");
        return modelAndView;
    }
}
