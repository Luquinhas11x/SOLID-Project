package com.training.rh.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeEntity {
    private PersonalDataEntity personalData;
    private LocalDate dateLastReadjustment;

    public EmployeeEntity(){

    }

    public EmployeeEntity(PersonalDataEntity personalData) {
        this.personalData = personalData;
    }

    public void updateSalary(BigDecimal newSalary) {
        this.personalData.setSalary(newSalary);
        this.dateLastReadjustment = LocalDate.now();
    }

    public void promote(OfficeEntity newOffice) {
        this.personalData.setOffice(newOffice);
    }

    public PersonalDataEntity getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalDataEntity personalData) {
        this.personalData = personalData;
    }

    public LocalDate getDateLastReadjustment() {
        return dateLastReadjustment;
    }

    public void setDateLastReadjustment(LocalDate dateLastReadjustment) {
        this.dateLastReadjustment = dateLastReadjustment;
    }
}
