package ua.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

@Controller
@Transactional
public class MainController {

    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public ModelAndView asdf() {
        return new ModelAndView("abc");
    }
}