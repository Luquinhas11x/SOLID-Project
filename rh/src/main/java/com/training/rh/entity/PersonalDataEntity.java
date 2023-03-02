package com.training.rh.entity;

import java.math.BigDecimal;

public class PersonalDataEntity {
    private String name;
    private String cpf;
    private OfficeEntity office;
    private BigDecimal salary;

    public PersonalDataEntity(){

    }
    public PersonalDataEntity(String name, String cpf, OfficeEntity office, BigDecimal salary) {
        this.name = name;
        this.cpf = cpf;
        this.office = office;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public OfficeEntity getOffice() {
        return office;
    }

    public void setOffice(OfficeEntity office) {
        this.office = office;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
