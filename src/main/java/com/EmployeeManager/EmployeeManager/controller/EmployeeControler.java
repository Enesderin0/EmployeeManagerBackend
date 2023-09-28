package com.EmployeeManager.EmployeeManager.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManager.EmployeeManager.dto.requests.AddEmployeeRequest;
import com.EmployeeManager.EmployeeManager.dto.requests.UpdateEmployeeRequest;
import com.EmployeeManager.EmployeeManager.dto.responses.GetAllEmployeeResponse;
import com.EmployeeManager.EmployeeManager.dto.responses.GetOneEmployeeResponse;
import com.EmployeeManager.EmployeeManager.services.EmployeeService;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeControler {
	
	private EmployeeService employeeService;
	
	@GetMapping
	public List<GetAllEmployeeResponse> getAllEmployee(){
		return this.employeeService.getAllEmployee();
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addEmployee(@RequestBody AddEmployeeRequest addEmployeeRequest){
		this.employeeService.addEmployee(addEmployeeRequest);
		return ResponseEntity.ok("Saved Employee");
		
	}
	
	
	@GetMapping("/{id}")
	public GetOneEmployeeResponse getOneEmployee(@PathVariable Long id) {
		return this.employeeService.getOneEmployee(id);
	}
	
	@PutMapping("/{id}")
	public UpdateEmployeeRequest updateEmployee(@PathVariable Long id,@RequestBody UpdateEmployeeRequest employeeRequest) {
		return this.employeeService.updateEmployee(id, employeeRequest);
	}
	
	@DeleteMapping("/{id}")
		public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
			this.employeeService.deleteEmployee(id);
			return ResponseEntity.ok("Deleted Employee");
		}
	
	
}
