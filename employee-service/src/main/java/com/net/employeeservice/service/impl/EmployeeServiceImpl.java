package com.net.employeeservice.service.impl;

import com.net.employeeservice.dto.APIResponseDto;
import com.net.employeeservice.dto.DepartmentDto;
import com.net.employeeservice.dto.EmployeeDto;
import com.net.employeeservice.entity.Employee;
import com.net.employeeservice.repostiory.EmployeeRepository;
import com.net.employeeservice.service.ApiClient;
import com.net.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

//    private RestTemplate restTemplate;
//    private WebClient webClient;

    private ApiClient apiClient;
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeedto) {

        Employee emp = modelMapper.map(employeedto, Employee.class);

        Employee savedEmployee = employeeRepository.save(emp);

        EmployeeDto newEmp = modelMapper.map(savedEmployee, EmployeeDto.class);

        return newEmp;
    }

    @Override
    public APIResponseDto getEmployeebyId(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

        /*** using rest Template **/
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/depcode?code="
//                + employee.getDepartmentCode(), DepartmentDto.class);
//
//        DepartmentDto resDepartment = responseEntity.getBody();

        /*** using web client **/
//       DepartmentDto resDepartment = webClient.get().uri("http://localhost:8080/api/departments/depcode?code="
//                        + employee.getDepartmentCode())
//                .retrieve().bodyToMono(DepartmentDto.class).block();

        /** Using spring open feign **/

       DepartmentDto resDepartment = apiClient.getDepartmentCode(employee.getDepartmentCode());

        EmployeeDto resEmployee = modelMapper.map(employee, EmployeeDto.class);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(resEmployee);
        apiResponseDto.setDepartment(resDepartment);

        return apiResponseDto;
    }
}
