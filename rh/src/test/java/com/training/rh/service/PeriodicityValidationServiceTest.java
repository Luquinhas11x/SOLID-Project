package com.training.rh.service;

import com.training.rh.entity.EmployeeEntity;
import com.training.rh.entity.OfficeEntity;
import com.training.rh.entity.PersonalDataEntity;
import com.training.rh.exception.ValidationException;
import com.training.rh.services.PeriodicityValidationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PeriodicityValidationServiceTest {

    @Test
    public void shouldThrowError_whenPeriodicityValidationIsLessThanSix(){
        BigDecimal salary = new BigDecimal("2500");

        EmployeeEntity employee = new EmployeeEntity(
                new PersonalDataEntity("Lucas", "40788861832", OfficeEntity.ASSISTANT, salary)
        );

        employee.setDateLastReadjustment(LocalDate.of(2022, 6, 10));

        ValidationException actualException = Assertions.assertThrows(ValidationException.class, () -> {
            PeriodicityValidationService.validate(employee, new BigDecimal("1300"));
        });

        String expectedMessage = "Intervalo entre reajuste deve ser no mínimo de 6 mêses!";

        Assertions.assertEquals(expectedMessage, actualException.getMessage());
    }
}
