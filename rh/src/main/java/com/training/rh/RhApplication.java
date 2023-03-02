package com.training.rh;

import com.training.rh.entity.EmployeeEntity;
import com.training.rh.entity.PersonalDataEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class RhApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhApplication.class, args);

//		Scanner entrada = new Scanner(System.in);
//
//		EmployeeEntity employee = new EmployeeEntity();
//
//		PersonalDataEntity personalData = new PersonalDataEntity();
//
//		System.out.println("Digite o nome: ");
//		employee.setPersonalData(personalData.setName(entrada.nextLine()));
	}
}
