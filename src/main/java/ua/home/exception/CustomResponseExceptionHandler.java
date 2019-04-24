package ua.home.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ua.home.service.GuideService;

@ControllerAdvice
public class CustomResponseExceptionHandler extends ResponseEntityExceptionHandler {
    @Autowired
    GuideService guideService;
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFoundException(NotFoundException e, WebRequest req){
        ModelAndView modelAndView = new ModelAndView("delete","result",false);
        modelAndView.addObject("guides",guideService.findAllGuides());
        return modelAndView;
    }
}
