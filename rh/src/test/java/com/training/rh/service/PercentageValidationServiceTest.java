package com.training.rh.service;

import com.training.rh.entity.EmployeeEntity;
import com.training.rh.entity.OfficeEntity;
import com.training.rh.entity.PersonalDataEntity;
import com.training.rh.exception.ValidationException;
import com.training.rh.services.PercentageValidationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PercentageValidationServiceTest {

    @Test
    public void shouldThrowError_whenPeriodicityValidationIsLessThanSix() {
        BigDecimal salary = new BigDecimal("2500");

        EmployeeEntity employee = new EmployeeEntity(
                new PersonalDataEntity("Lucas", "40788861832", OfficeEntity.ASSISTANT, salary)
        );

        BigDecimal increase = new BigDecimal("1300");

        ValidationException actualException = Assertions.assertThrows(ValidationException.class, () -> {
            PercentageValidationService.validate(employee, increase);
        });

        String expectedMessage = "Reajuste não pode ser superior a 40% do salário!";

        Assertions.assertEquals(expectedMessage, actualException.getMessage());
    }
}
