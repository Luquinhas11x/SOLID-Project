package com.training.rh.service;

import com.training.rh.entity.EmployeeEntity;
import com.training.rh.entity.OfficeEntity;
import com.training.rh.entity.PersonalDataEntity;
import com.training.rh.interfaces.ReadjustmentValidation;
import com.training.rh.services.ReadjustmentSerivce;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReadjustmentSerivceTest {

    @InjectMocks
    @Spy
    ReadjustmentSerivce readjustmentSerivce;

    @Test
    public void updateSalary_whenEmployeeReceivesIncrease() {

        BigDecimal increase = new BigDecimal("900");

        BigDecimal salary = new BigDecimal("2500");

        EmployeeEntity employee = spy(new EmployeeEntity(
                new PersonalDataEntity("Lucas", "40788861832", OfficeEntity.ASSISTANT, salary)
        ));

        BigDecimal readjustedSalary = employee.getPersonalData().getSalary().add(increase);

        doNothing().when(readjustmentSerivce).validate((any()), any(EmployeeEntity.class), any(BigDecimal.class));

        readjustmentSerivce.readjustEmployeeSalary(employee, increase);

        Assertions.assertEquals(readjustedSalary, employee.getPersonalData().getSalary());
        verify(employee).updateSalary(readjustedSalary);
    }
}
