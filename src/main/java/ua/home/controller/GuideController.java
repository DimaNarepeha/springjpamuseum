package ua.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.home.entity.Guide;
import ua.home.service.GuideService;

@Controller
@RequestMapping
public class GuideController {
    @Autowired
    GuideService guideService;
    @GetMapping("/list")
    public ModelAndView all() {
        return new ModelAndView("list", "guides", guideService.findAllGuides());
    }
    @GetMapping("/add")
    public ModelAndView addGuide() {
        Guide guide = new Guide();
        return new ModelAndView("add");
    }

    @PostMapping("/add")
    public ModelAndView addGuide(@RequestParam String firstname,@RequestParam String lastname) {
        Guide guide = new Guide();
        guide.setFirstName(firstname);
        guide.setLastName(lastname);
        guideService.saveGuides(guide);
        return new ModelAndView("add","added",lastname);
    }
}
