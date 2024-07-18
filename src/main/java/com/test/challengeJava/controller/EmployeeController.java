package com.test.challengeJava.controller;

import com.test.challengeJava.data.ApiResponse;
import com.test.challengeJava.dto.EmployeeInfoDto;
import com.test.challengeJava.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/challenge/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<?>> getEmployee(@RequestParam(required = false)Long id){
        if(id == null){
            List<EmployeeInfoDto> employeesInfo = employeeService.getEmployeesInfo();
            ApiResponse<List<EmployeeInfoDto>> response = new ApiResponse<>(
                    "Employees retrieved",
                    String.valueOf(HttpStatus.OK.value()),
                    employeesInfo
            );
            return new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            EmployeeInfoDto employeeInfo = employeeService.getEmployeeInfoById(id);
            ApiResponse<EmployeeInfoDto> response = new ApiResponse<>(
                    "Employee retrieved",
                    String.valueOf(HttpStatus.OK.value()),
                    employeeInfo
            );
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
    }
}
