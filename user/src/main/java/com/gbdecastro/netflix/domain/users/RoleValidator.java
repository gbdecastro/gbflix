package com.gbdecastro.netflix.domain.users;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RoleValidator implements ConstraintValidator<ValidRole, String> {

    @Override
    public boolean isValid(String role, ConstraintValidatorContext context) {
        if (role == null) {
            return true;
        }
        try {
            RolesEnum.valueOf(role);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
