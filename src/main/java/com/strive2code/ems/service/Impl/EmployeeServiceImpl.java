package com.strive2code.ems.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.strive2code.ems.dto.EmployeeDto;
import com.strive2code.ems.entity.Employee;
import com.strive2code.ems.exception.ResourceNotFoundException;
import com.strive2code.ems.mapper.EmployeeMapper;
import com.strive2code.ems.repository.EmployeeRepo;
import com.strive2code.ems.service.EmployeeService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		
		Employee emp = employeeRepo.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(emp);
	}

	@Override
	public EmployeeDto getAnEmployee(Long id) {
		Employee emp = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with the give id: " + id));
		
		return EmployeeMapper.mapToEmployeeDto(emp);
	}

	@Override
	public List<EmployeeDto> getEmployees() {
		List<Employee> empl = employeeRepo.findAll();
		return empl.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto modifyAnEmployee(Long id, EmployeeDto updatedEmployee) {
		Employee emp = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with the give id: " + id));
		emp.setFirstName(updatedEmployee.getFirstName());
		emp.setLastName(updatedEmployee.getLastName());
		emp.setEmail(updatedEmployee.getEmail());
		Employee updatedempObj = employeeRepo.save(emp);
		
		
		return EmployeeMapper.mapToEmployeeDto(updatedempObj);
	}

	@Override
	public void deleteEmployee(Long id) {
		Employee emp = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with the give id: " + id));
		employeeRepo.delete(emp);
		
		
	}

}
