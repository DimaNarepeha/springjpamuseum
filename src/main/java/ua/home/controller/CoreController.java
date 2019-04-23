package ua.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoreController {

    /**
     * Handles request to welcome page
     * @return logical view name
     */
//    @GetMapping("/")
//    public ModelAndView onIndex() {
//        return new ModelAndView("index");
//    }
    @GetMapping("/")
    public String onIndex() {
        return "index";
    }
}
