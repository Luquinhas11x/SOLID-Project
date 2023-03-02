package com.training.rh.services;

import com.training.rh.entity.EmployeeEntity;
import com.training.rh.entity.OfficeEntity;
import com.training.rh.exception.ValidationException;

public class PromotionService {

    public static void promote(EmployeeEntity employee, Boolean goalAchieved) {
        OfficeEntity currentOffice = employee.getPersonalData().getOffice();
        if (OfficeEntity.MANAGER == currentOffice) {
            throw new ValidationException("Gerentes não podem ser promovidos!");
        }

        if (goalAchieved) {
            OfficeEntity newOffice = currentOffice.getNextOffice();
            employee.promote(newOffice);
        } else {
            throw new ValidationException("Funcionário não bateu a meta!");
        }
    }
}
