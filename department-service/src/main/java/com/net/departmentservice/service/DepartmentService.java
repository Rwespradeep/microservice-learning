package com.net.departmentservice.service;

import com.net.departmentservice.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto getDepartmentById(Long id);

    DepartmentDto getDepartmentByCode(String Code);
}
