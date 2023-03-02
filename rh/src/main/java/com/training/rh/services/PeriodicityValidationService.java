package com.training.rh.services;

import com.training.rh.entity.EmployeeEntity;
import com.training.rh.exception.ValidationException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PeriodicityValidationService {

    public static void validate(EmployeeEntity employee, BigDecimal increase) {
        LocalDate lastReadjustmentDate = employee.getDateLastReadjustment();
        LocalDate currentDate = LocalDate.of(2022, 9, 12);
        long monthsSinceLastReadjustment = ChronoUnit.MONTHS.between(lastReadjustmentDate, currentDate);
        if (monthsSinceLastReadjustment < 6) {
            throw new ValidationException("Intervalo entre reajuste deve ser no mínimo de 6 mêses!");
        }
    }
}
