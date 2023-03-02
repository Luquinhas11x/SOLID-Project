package com.training.rh.interfaces;

import com.training.rh.entity.EmployeeEntity;

import java.math.BigDecimal;

public interface ReadjustmentValidation {
     default void validate(EmployeeEntity employee, BigDecimal increase) {
    }
}
