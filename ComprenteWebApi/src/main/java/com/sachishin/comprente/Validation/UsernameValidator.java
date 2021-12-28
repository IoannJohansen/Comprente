package com.sachishin.comprente.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<LoginConstraint, String> {

    @Override
    public void initialize(LoginConstraint contactNumber) {
    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext cxt) {
        return contactField != null && (contactField.length() >= 4) && (contactField.length() <= 12);
    }
}

