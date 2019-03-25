package ua.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*import ua.home.entity.Guess;
import ua.home.service.GuessService;*/
import ua.home.entity.Test;
import ua.home.service.TestService;
import ua.home.service.TestValidator;
import ua.home.wire.TestResponse;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Locale;

@Controller
@Transactional
public class TestController {

    private static final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
   /* static {
        messageSource.setBasename("message");
    }*/

    @Autowired
    private  TestService testService;
    @Autowired
    private TestValidator testValidator;
    /*@Autowired
    private GuessService guessService;*/
    @RequestMapping(value = "/create{number}", method = RequestMethod.POST)
    public ResponseEntity<?> create(@PathVariable("number")Integer number){
        testService.save(number);
          return new ResponseEntity(HttpStatus.CREATED);

    }
   // @Validated
    @RequestMapping(value = "/read{number}", method = RequestMethod.GET)
    public ResponseEntity<?> read(@PathVariable("number")  Integer number){
   Test test = new Test();
   test.setNumber(number);
        final DataBinder dataBinder = new DataBinder(test);
       dataBinder.addValidators(testValidator);
       dataBinder.validate();
       if (dataBinder.getBindingResult().hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                /*   forEach(e -> System.out.println(messageSource
                            .getMessage(e, Locale.getDefault())));*/
      }
        TestResponse response = new TestResponse(testService.get(number));
        return new ResponseEntity<>(response.getJson(), response.getResponseHeaders(), HttpStatus.OK);
        //return new ResponseEntity(HttpStatus.OK);
    }


  /*      @RequestMapping(value = "/plays/{number}", method = RequestMethod.POST)

         public ResponseEntity<?> play(@PathVariable Integer number) {
        Guess guess = new Guess();
        guess.setGuess(number);
        guessService.save(guess);
        return new ResponseEntity<>( HttpStatus.OK);
    }*/

}
