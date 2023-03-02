package com.training.rh.services;

import com.training.rh.entity.EmployeeEntity;
import com.training.rh.interfaces.ReadjustmentValidation;

import java.math.BigDecimal;
import java.util.List;

public class ReadjustmentSerivce {

    private final List<ReadjustmentValidation> validations;

    public ReadjustmentSerivce(List<ReadjustmentValidation> validations) {
        this.validations = validations;
    }

    public void readjustEmployeeSalary(EmployeeEntity employee, BigDecimal increase) {
//         pior jeito:
//        PercentageValidationService.validate(employee, increase);
//        PeriodicityValidationService.validate(employee, increase);

        //melhor jeito:
//        this.validations.forEach(v -> v.validate(employee, increase));
        this.validate(this.validations, employee, increase);

        BigDecimal readjustedSalary = employee.getPersonalData().getSalary().add(increase);

        employee.updateSalary(readjustedSalary);
    }

    public void validate(List<ReadjustmentValidation> validationList, EmployeeEntity employee, BigDecimal increase){
        validationList.forEach(v -> v.validate(employee, increase));
    }
}
