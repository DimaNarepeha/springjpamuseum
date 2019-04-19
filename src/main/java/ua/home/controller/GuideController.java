package ua.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.home.dao.TestDAO;
import ua.home.entity.Guide;
import ua.home.service.GuideService;

@Controller
@RequestMapping
public class GuideController {
    @Autowired
    GuideService guideService;
    @Autowired
    TestDAO testDAO;
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

       // testDAO.save();
        return new ModelAndView("add","added",lastname);
    }
    @GetMapping("/delete")
    public ModelAndView deleteGuide() {
        return new ModelAndView("delete","guides",guideService.findAllGuides());
    }
    @PostMapping("/delete")
    public ModelAndView deleteGuide(@RequestParam String id) {

        guideService.deleteGuides(Integer.parseInt(id));
        return new ModelAndView("delete","deleted",id);
    }

    @GetMapping("/update")
    public ModelAndView updateGuide() {
        return new ModelAndView("update","guides",guideService.findAllGuides());
    }
    @PostMapping("/update")
    public ModelAndView updateGuide(@RequestParam String id,@RequestParam String first,
                                    @RequestParam String last) {
        Guide guide = new Guide();
        guide.setId(Integer.parseInt(id));
        guide.setFirstName(first);
        guide.setLastName(last);
        guideService.updateGuides(guide);
        return new ModelAndView("update","guides",guideService.findAllGuides());
    }
}
