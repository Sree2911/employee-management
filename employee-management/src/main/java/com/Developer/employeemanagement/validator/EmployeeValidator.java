package com.Developer.employeemanagement.validator;

import com.Developer.employeemanagement.entity.EmployeeEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeValidator {
    public List<String> validateEmployee(EmployeeEntity employee) {
        List<String> errors = new ArrayList<>();

        // Check if name is empty
        if (employee.getName() == null || employee.getName().isEmpty()) {
            errors.add("Name cannot be empty.");
        }

        // Check if date of birth is null
        if (employee.getDateOfBirth() == null) {
            errors.add("Date of birth cannot be null.");
        }

        // Add more validation rules as needed (e.g., email format, age range)

        return errors;
    }
}
