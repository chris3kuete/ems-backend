package com.strive2code.ems.service;

import java.util.List;

//import com.strive2code.ems.controller.EmployeedDto;
import com.strive2code.ems.dto.EmployeeDto;
import com.strive2code.ems.entity.Employee;

public interface EmployeeService {

	EmployeeDto addEmployee(EmployeeDto employeeDto);

	EmployeeDto getAnEmployee(Long id);

	List<EmployeeDto> getEmployees();

	EmployeeDto modifyAnEmployee(Long id, EmployeeDto updatedEmployee);

	void deleteEmployee(Long id);

}
