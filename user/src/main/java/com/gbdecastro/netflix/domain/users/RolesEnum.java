package com.gbdecastro.netflix.domain.users;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public enum RolesEnum {
    USER,
    ADMIN
}
