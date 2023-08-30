package com.net.employeeservice.controller;

import com.net.employeeservice.dto.APIResponseDto;
import com.net.employeeservice.dto.EmployeeDto;
import com.net.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    //save employee
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto emp){
        EmployeeDto savedEmployee = employeeService.saveEmployee(emp);
        return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
    }

    //get employee
    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable Long id){
        APIResponseDto apiResponseDto = employeeService.getEmployeebyId(id);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}
