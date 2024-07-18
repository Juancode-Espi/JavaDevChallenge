package com.test.challengeJava.business;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class EmployeeBusinessImpl {
    public long getAnualSalary(long mensualSalary) {
        return mensualSalary * 12;
    }    
}
