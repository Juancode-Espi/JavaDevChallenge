package com.test.challengeJava.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.challengeJava.business.EmployeeBusinessImpl;
import com.test.challengeJava.data.ApiResponse;
import com.test.challengeJava.data.Employee;
import com.test.challengeJava.dto.EmployeeInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class EmployeeService {

    private final String GET_EMPLOYEES_URL= "http://dummy.restapiexample.com/api/v1/employees";
    private final String GET_EMPLOYEE_URL= "http://dummy.restapiexample.com/api/v1/employee/";
    private final EmployeeBusinessImpl employeeBusiness;
    private final RestTemplate restTemplate;

    @Autowired
    public EmployeeService (EmployeeBusinessImpl employeeBusiness, RestTemplate restTemplate){
        this.employeeBusiness = employeeBusiness;
        this.restTemplate = restTemplate;
    }

    public EmployeeInfoDto getEmployeeInfoById(long id){
        ApiResponse<LinkedHashMap> employeeApiResponse = restTemplate.getForObject(GET_EMPLOYEE_URL+id, ApiResponse.class);
        ObjectMapper mapper = new ObjectMapper();
        Employee employee = mapper.convertValue(employeeApiResponse.getData(),Employee.class);
        EmployeeInfoDto employeeInfo = buildEmployeeInfoDto(employee);
        return employeeInfo;
    }
    public List<EmployeeInfoDto> getEmployeesInfo(){
        ApiResponse<List<LinkedHashMap>> employeesApiResponse = restTemplate.getForObject(GET_EMPLOYEES_URL, ApiResponse.class);
        ObjectMapper mapper = new ObjectMapper();
        List<LinkedHashMap> employees = employeesApiResponse.getData();
        List<EmployeeInfoDto> employeesInfo= new ArrayList<>();
        for (int i=0; i < employees.size(); i++){
            Employee employee = mapper.convertValue(employees.get(i), Employee.class);
            EmployeeInfoDto employeeInfo = buildEmployeeInfoDto(employee);
            employeesInfo.add(employeeInfo);
        }
        return employeesInfo;
    }

    private EmployeeInfoDto buildEmployeeInfoDto(Employee employee){
        return new EmployeeInfoDto(employee.getId(), employee.getName(), employee.getSalary(),
                employee.getAge(),employee.getProfileImage(), employeeBusiness.getAnualSalary(employee.getSalary()));
    }
}
