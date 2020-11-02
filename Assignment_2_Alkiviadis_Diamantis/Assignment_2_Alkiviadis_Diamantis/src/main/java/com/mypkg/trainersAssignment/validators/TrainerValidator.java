package com.mypkg.trainersAssignment.validators;

import com.mypkg.trainersAssignment.model.Trainer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TrainerValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Trainer.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Trainer t = (Trainer) o;

        if ("".equals(t.getName().trim())) {

            errors.rejectValue("name", "name.wrong");
        }
        if("".equals(t.getSurname().trim())){
        
        errors.rejectValue("surname", "surname.wrong");
        }

    }

}
