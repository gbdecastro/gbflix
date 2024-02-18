package com.gbdecastro.netflix.domain.users;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class RoleValidator implements ConstraintValidator<ValidRole, List<String>> {

    @Override
    public boolean isValid(List<String> roles, ConstraintValidatorContext context) {
        if (roles == null) {
            return true; // Consider null as valid. Use @NotNull for null checks.
        }
        for (String role : roles) {
            try {
                RolesEnum.valueOf(role); // Verifica se a string é um valor válido do enum Role.
            } catch (IllegalArgumentException e) {
                return false; // Se qualquer valor não for válido, retorna falso.
            }
        }
        return true; // Todos os valores são válidos.
    }
}
