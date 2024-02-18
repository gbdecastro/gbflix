package com.gbdecastro.netflix.domain.users;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

@Documented
@Constraint(validatedBy = RoleValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@NotEmpty(message = "{role_required}")
public @interface ValidRole {
    String message() default "{role_invalid}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
