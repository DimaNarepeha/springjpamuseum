package ua.home.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.home.dao.ExhibitGuideDao;
import ua.home.entity.Exhibit;
import ua.home.service.ExhibitService;
import ua.home.service.GuideService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static ua.home.Util.ExhibitUtil.checkIfNoEmptyFieldsIn;
import static ua.home.Util.ExhibitUtil.getExhibitFromString;


@Controller
public class ExhibitController {
    @Autowired
    ExhibitService exhibitService;

    @Autowired
    GuideService guideService;

    @Autowired
    ExhibitGuideDao exhibitGuideDao;

    @GetMapping("/addExhibit")
    public ModelAndView addExhibitPage() {
        ModelAndView modelAndView = new ModelAndView("addExhibit");
        modelAndView.addObject("exhibits", exhibitService.readAllExhibits());
        return modelAndView;
    }

    @PostMapping("/addExhibit")
    public ModelAndView addExhibitToDb(@RequestBody String json) {
        Exhibit exhibit = getExhibitFromString(json);
        ModelAndView modelAndView = new ModelAndView("addExhibit");
        if (!checkIfNoEmptyFieldsIn(exhibit)) {
            modelAndView.addObject("success", 0);
            modelAndView.addObject("exhibits", exhibitService.readAllExhibits());
            return modelAndView;
        }
        exhibitService.saveExhibit(exhibit);
        modelAndView.addObject("exhibits", exhibitService.readAllExhibits());
        modelAndView.addObject("success", 1);
        System.out.println(exhibit);
        return modelAndView;
    }

    @GetMapping("/listExhibit")
    public ModelAndView listExhibit() {
        ModelAndView modelAndView = new ModelAndView("listExhibit");
        modelAndView.addObject("exhibits", exhibitService.readAllExhibits());
        return modelAndView;
    }

    @GetMapping("/deleteExhibit")
    public ModelAndView deleteExhibitGetPage() {
        ModelAndView modelAndView = new ModelAndView("deleteExhibit");
        modelAndView.addObject("exhibits", exhibitService.readAllExhibits());
        return modelAndView;
    }

    @PostMapping("/deleteExhibit")
    public ModelAndView deleteExhibitFromDb(@RequestParam(value = "toDelete") String[] paramValues) {
        int amountOfDeleted = 0;
        if (paramValues != null) {
            for (String str : paramValues) {
                amountOfDeleted += exhibitService.deleteExhibit(Integer.parseInt(str));
            }
        }
        ModelAndView modelAndView = new ModelAndView("deleteExhibit");
        modelAndView.addObject("exhibits", exhibitService.readAllExhibits());
        modelAndView.addObject("deleted", amountOfDeleted);
        return modelAndView;
    }

    @GetMapping("/updateExhibitList")
    public ModelAndView updateExhibitPage() {
        ModelAndView modelAndView = new ModelAndView("updateExhibitList");
        modelAndView.addObject("exhibits", exhibitService.readAllExhibits());
        return modelAndView;
    }

    @PostMapping("/updateExhibitList")
    public ModelAndView updateExhibitRedirect(@RequestParam(value = "id") String id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/updateExhibit?id=" + id);
        modelAndView.addObject("exhibitToUpdate", exhibitService.getExhibitById(Integer.parseInt(id)));
        return modelAndView;
    }

    @GetMapping("/updateExhibit")
    public ModelAndView updateExhibitPage(@RequestParam(name = "id") String id) {
        ModelAndView modelAndView = new ModelAndView("updateExhibit");
        modelAndView.addObject("exhibitToUpdate", exhibitService.getExhibitById(Integer.parseInt(id)));
        return modelAndView;
    }

    @PostMapping("/updateExhibit")
    public ModelAndView updateExhibitInDb(@RequestBody String exhibitStr) {
        Exhibit editedExhibit = getExhibitFromString(exhibitStr);
        ModelAndView modelAndView = new ModelAndView("updateExhibit");
        if (checkIfNoEmptyFieldsIn(editedExhibit)) {
            exhibitService.updateExhibit(editedExhibit);
            modelAndView.addObject("exhibitToUpdate", editedExhibit);
            modelAndView.addObject("updated", 1);
        } else {
            modelAndView.addObject("exhibitToUpdate", editedExhibit);
            modelAndView.addObject("updated", 0);
        }
        return modelAndView;
    }

    @GetMapping(value = "/updateRelation")
    public ModelAndView listExhibitWithButtonsPage() {
        ModelAndView modelAndView = new ModelAndView("ListExhibitWithButtons");
        modelAndView.addObject("exhibits", exhibitService.readAllExhibits());
        return modelAndView;
    }

    @PostMapping(value = "/updateRelation")
    public ModelAndView updateRelationInDbPage(@RequestParam(value = "id") String id) {
        int idInt = Integer.parseInt(id);
        ModelAndView modelAndView = new ModelAndView("dragndropaddguideexhibit");
        modelAndView.addObject("exhibit", exhibitService.getExhibitById(idInt));
        modelAndView.addObject("idOldExhibit", id);
        modelAndView.addObject("currentGuides", exhibitGuideDao.getGuidesByExhibitId(idInt));
        modelAndView.addObject("guidesInDatabase", exhibitGuideDao.getGuidesThatAreNotInThisExhibitById(idInt));
        return modelAndView;
    }

    @PostMapping(value = "/updateRelations")
    public ModelAndView updateRelationInDb(@RequestParam(value = "id") String id,
                                           @RequestParam(value = "idsToUpdate") String idsToUpdate) {
        int idInt = Integer.parseInt(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/dragndropaddguideexhibit");
        List<String> stringList = Arrays.asList(idsToUpdate.split(" "));
        HashSet<Integer> ids = new HashSet<>();
        for (int i = 0; i < stringList.size(); i++) {
            try {
                if(stringList.get(i).equals("")){
                    continue;
                }
                ids.add(Integer.valueOf(stringList.get(i)));
            } catch (NumberFormatException e) {

            }
        }
        exhibitGuideDao.reconnectRelations(ids, idInt);
        modelAndView.addObject("exhibit", exhibitService.getExhibitById(idInt));
        modelAndView.addObject("idOldExhibit", id);
        modelAndView.addObject("currentGuides", exhibitGuideDao.getGuidesByExhibitId(idInt));
        modelAndView.addObject("guidesInDatabase", exhibitGuideDao.getGuidesThatAreNotInThisExhibitById(idInt));
        modelAndView.addObject("success", 1);
        return modelAndView;
    }
}
