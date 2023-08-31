package com.EmployeeManager.EmployeeManager.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeManager.EmployeeManager.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
