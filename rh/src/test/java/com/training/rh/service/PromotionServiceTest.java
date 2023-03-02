package com.training.rh.service;

import com.training.rh.entity.EmployeeEntity;
import com.training.rh.entity.OfficeEntity;
import com.training.rh.entity.PersonalDataEntity;
import com.training.rh.exception.ValidationException;
import com.training.rh.services.PromotionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


public class PromotionServiceTest {

    @Test
    public void shouldPromote_whenGoalIsReached() {

        EmployeeEntity employee = new EmployeeEntity(
                new PersonalDataEntity("Lucas", "40788861832", OfficeEntity.ASSISTANT, BigDecimal.TEN)
        );

        OfficeEntity office = employee.getPersonalData().getOffice();

        OfficeEntity currentOffice = office.getNextOffice();

        OfficeEntity expectedOffice = OfficeEntity.ANALYST;

        employee.promote(office);

        boolean goalAchived = true;

        PromotionService.promote(employee, goalAchived);

        Assertions.assertEquals(expectedOffice, currentOffice);
    }

    @Test
    public void shouldThrowError_whenEmployeeDoesntReachTheGoal() {

        EmployeeEntity employee = new EmployeeEntity(
                new PersonalDataEntity("Lucas", "40788861832", OfficeEntity.ASSISTANT, BigDecimal.TEN)
        );

        boolean goalAchived = false;

        ValidationException actualException = Assertions.assertThrows(ValidationException.class, () -> {
            PromotionService.promote(employee, goalAchived);
        });

        String expectedMessage = "Funcionário não bateu a meta!";

        Assertions.assertEquals(expectedMessage, actualException.getMessage());

    }

    @Test
    public void shouldThrowError_whenEmployeeOfficeIsManager() {

        EmployeeEntity employee = new EmployeeEntity(
                new PersonalDataEntity("Lucas", "1312321321", OfficeEntity.MANAGER, BigDecimal.TEN)
        );

        boolean goalAchived = true;

        OfficeEntity employeeOffice = employee.getPersonalData().getOffice();

        ValidationException actualException = Assertions.assertThrows(ValidationException.class, () -> {
            PromotionService.promote(employee, goalAchived);
        });

        String expectedMessage = "Gerentes não podem ser promovidos!";

        Assertions.assertEquals(expectedMessage, actualException.getMessage());
    }
}
