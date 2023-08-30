package com.net.departmentservice.controller;

import com.net.departmentservice.dto.DepartmentDto;
import com.net.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    //build save department rest api
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getallDepartmentsfromservice(){
        List<DepartmentDto> allDepartments = departmentService.getAllDepartments();
        return new ResponseEntity<>(allDepartments, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentId(@PathVariable Long id){
        DepartmentDto getDepart = departmentService.getDepartmentById(id);
        return new ResponseEntity<>(getDepart,HttpStatus.OK);
    }

    @GetMapping(value = "/depcode")
    public ResponseEntity<DepartmentDto> getDepartmentCode(@RequestParam String code){
        DepartmentDto getDepartCode = departmentService.getDepartmentByCode(code);
        return new ResponseEntity<>(getDepartCode, HttpStatus.OK);
    }
}
