package com.test.challengeJava.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private long id;
    @JsonProperty("employee_name")
    private String name;
    @JsonProperty("employee_salary")
    private long salary;
    @JsonProperty("employee_age")
    private int age;
    @JsonProperty("profile_image")
    private String profileImage;

}
