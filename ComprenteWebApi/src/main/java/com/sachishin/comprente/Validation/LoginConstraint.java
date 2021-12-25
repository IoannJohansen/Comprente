package com.sachishin.comprente.Validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UsernameValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginConstraint {
    String message() default "Invalid sername";
    Class<?>[]groups() default {};
    Class<? extends Payload>[]payload() default {};
}
