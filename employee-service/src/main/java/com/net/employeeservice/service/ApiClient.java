package com.net.employeeservice.service;

import com.net.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface ApiClient {

    @GetMapping(value = "api/departments/depcode")
    DepartmentDto getDepartmentCode(@RequestParam String code);


}
