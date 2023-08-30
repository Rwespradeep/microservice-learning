package com.net.employeeservice.service;

import com.net.employeeservice.dto.APIResponseDto;
import com.net.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeedto);

    APIResponseDto getEmployeebyId(Long employeeId);
}
