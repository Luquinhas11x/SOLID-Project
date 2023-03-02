package com.training.rh.entity;

public class OutSourcedEntity {

    private PersonalDataEntity personalData;
    private String companyName;

    public OutSourcedEntity(PersonalDataEntity personalData, String companyName) {
        this.personalData = personalData;
        this.companyName = companyName;
    }

    public PersonalDataEntity getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalDataEntity personalData) {
        this.personalData = personalData;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
