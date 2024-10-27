package com.strive2code.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.strive2code.ems.dto.EmployeeDto;

import com.strive2code.ems.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		
		EmployeeDto empDto = employeeService.addEmployee(employeeDto);
		return new ResponseEntity<>(empDto, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> lookForEmployee(@PathVariable("id") Long id){
		EmployeeDto emp = employeeService.getAnEmployee(id);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> emp = employeeService.getEmployees();
		return new ResponseEntity<>(emp, HttpStatus.OK);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> modifyEmployee(@PathVariable Long id,@RequestBody EmployeeDto updatedEmployee){
		EmployeeDto emp = employeeService.modifyAnEmployee(id, updatedEmployee);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public void deleteAnEmployee(@PathVariable Long id){
		employeeService.deleteEmployee(id);
		
		
	}

}
