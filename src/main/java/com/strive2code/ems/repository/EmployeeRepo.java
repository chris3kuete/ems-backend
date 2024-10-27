package com.strive2code.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.strive2code.ems.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
