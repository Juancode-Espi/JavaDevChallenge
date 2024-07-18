package com.test.challengeJava.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeInfoDto {

    private long id;
    private String name;
    private long salary;
    private int age;
    private String profileImage;
    private long anualSalary;

}
