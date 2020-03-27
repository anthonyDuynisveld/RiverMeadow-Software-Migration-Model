package com.rivermeadow.assignment.ultilities;


import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueIPValidator.class)
public @interface UniqueIP {
    String message() default "Ip duplicated across two validations";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
