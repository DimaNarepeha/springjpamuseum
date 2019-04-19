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

        if(firstname.equals("") || lastname.equals("")){

            return new ModelAndView("add","added",false);

        }
        Guide guide = new Guide();
        guide.setFirstName(firstname);
        guide.setLastName(lastname);
        guideService.saveGuides(guide);
        return new ModelAndView("add","added",true);
    }
    @GetMapping("/delete")
    public ModelAndView deleteGuide() {
        return new ModelAndView("delete","guides",guideService.findAllGuides());
    }
    @PostMapping("/delete")
    public ModelAndView deleteGuide(@RequestParam String id) {
try {
    guideService.deleteGuides(Integer.parseInt(id));
}catch(Exception e){
    ModelAndView modelAndView = new ModelAndView("delete","result",false);
    modelAndView.addObject("guides",guideService.findAllGuides());
    return modelAndView;

}
        ModelAndView modelAndView = new ModelAndView("delete","result",true);
        modelAndView.addObject("guides",guideService.findAllGuides());
        return modelAndView;
    }

    @GetMapping("/update")
    public ModelAndView updateGuide() {
        return new ModelAndView("update","guides",guideService.findAllGuides());
    }
    @PostMapping("/update")
    public ModelAndView updateGuide(@RequestParam String id,@RequestParam String first,
                                    @RequestParam String last) {
        Guide guide = new Guide();
        try {
            guide.setId(Integer.parseInt(id));
        }catch(NumberFormatException e){
            ModelAndView modelAndView = new ModelAndView("update","guides",null);
            modelAndView.addObject("guides",guideService.findAllGuides());
            return modelAndView;
        }
        guide.setFirstName(first);
        guide.setLastName(last);
        guideService.updateGuides(guide);
        ModelAndView modelAndView = new ModelAndView("update","guides",guideService.findAllGuides());
        modelAndView.addObject("result",guideService.findAllGuides());
        return modelAndView;

    }
}
