package ua.home.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.home.entity.Test;

@Service
public class TestValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Test.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Test p = (Test) obj;
        if (p.getNumber() < 0) {
            errors.rejectValue("number", "value.negative");
        }
    }
}