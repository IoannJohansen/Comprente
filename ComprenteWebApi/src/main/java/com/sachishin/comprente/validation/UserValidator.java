package com.sachishin.comprente.validation;

import com.sachishin.comprente.Repository.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        User u = (User)target;
        if(u.getName().length()==0){
            errors.rejectValue("name", "The name of user field is too short");
        }else if(u.getName().length()>30){
            errors.rejectValue("name", "The name of user field is too long");
        }
    }
}
