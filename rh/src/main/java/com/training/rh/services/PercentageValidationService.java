package com.training.rh.services;

import com.training.rh.entity.EmployeeEntity;
import com.training.rh.exception.ValidationException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PercentageValidationService {

    public static void validate(EmployeeEntity employee, BigDecimal increase) {
        BigDecimal currentSalary = employee.getPersonalData().getSalary();
        BigDecimal percentageReadjustment = increase.divide(currentSalary, RoundingMode.HALF_UP);
        if (percentageReadjustment.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidationException("Reajuste não pode ser superior a 40% do salário!");
        }
    }
}
