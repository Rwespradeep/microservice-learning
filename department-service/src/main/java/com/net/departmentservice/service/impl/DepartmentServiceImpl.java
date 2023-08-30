package com.net.departmentservice.service.impl;

import com.net.departmentservice.dto.DepartmentDto;
import com.net.departmentservice.entity.Department;
import com.net.departmentservice.repository.DepartmentRepository;
import com.net.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        // convert department dto to jpa entity
        Department department = modelMapper.map(departmentDto,Department.class);
        //saving in repository
        Department newdepartment = departmentRepository.save(department);
        //now converting this entity into dto
        return modelMapper.map(newdepartment,DepartmentDto.class);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department) ->
                modelMapper.map(department, DepartmentDto.class)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
       Department oneDepartment = departmentRepository.findById(id).orElseThrow();
       return modelMapper.map(oneDepartment, DepartmentDto.class);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department oneDepartment  = departmentRepository.findByDepartmentCode(departmentCode);
        return modelMapper.map(oneDepartment, DepartmentDto.class);
    }
}
