package com.EmployeeManager.EmployeeManager.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManager.EmployeeManager.config.modelMapper.ModelMapperService;
import com.EmployeeManager.EmployeeManager.dto.requests.AddEmployeeRequest;
import com.EmployeeManager.EmployeeManager.dto.requests.UpdateEmployeeRequest;
import com.EmployeeManager.EmployeeManager.dto.responses.GetAllEmployeeResponse;
import com.EmployeeManager.EmployeeManager.dto.responses.GetOneEmployeeResponse;
import com.EmployeeManager.EmployeeManager.entities.Employee;
import com.EmployeeManager.EmployeeManager.repos.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	@Autowired
	private ModelMapperService mapperService;
	
	public List<GetAllEmployeeResponse> getAllEmployee(){
		return this.repository.findAll().stream().map(employee->this.mapperService.forResponses().map(employee, GetAllEmployeeResponse.class)).collect(Collectors.toList());
	}
	
	public void addEmployee(AddEmployeeRequest addEmployeeRequest){
		Employee employee = this.mapperService.forRequest().map(addEmployeeRequest, Employee.class);
		this.repository.save(employee);
	}
	
	public GetOneEmployeeResponse getOneEmployee(Long id) {
		Optional<Employee> employee = this.repository.findById(id);
		if(employee.isPresent())
			return this.mapperService.forResponses().map(employee,GetOneEmployeeResponse.class);
		else
			return null;
	}
	
	public UpdateEmployeeRequest updateEmployee(Long id,UpdateEmployeeRequest employeeRequest) {
		Optional<Employee> employee= this.repository.findById(id);
		if(employee.isPresent()) {
			Employee employee2=employee.get();
			this.mapperService.forRequest().map(employeeRequest, employee2);
			this.repository.save(employee2);
			/*
			 * employee2.setName(employeeRequest.getName());
			 * employee2.setSurname(employeeRequest.getSurname());
			 * employee2.setEmail(employeeRequest.getEmail());
			 * employee2.setPrice(employeeRequest.getPrice());
			 * employee2.setDepartment(employeeRequest.getDepartment());
			 * this.repository.save(employee2);
			 */
			return this.mapperService.forRequest().map(employee2,UpdateEmployeeRequest.class);
		}else {
			return null;
		}
	}
	
	public void deleteEmployee(Long id) {
		this.repository.deleteById(id);
	}
}

