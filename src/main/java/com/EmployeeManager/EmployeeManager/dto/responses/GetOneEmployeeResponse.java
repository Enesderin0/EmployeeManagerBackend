package com.EmployeeManager.EmployeeManager.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOneEmployeeResponse {
	private long id;
	private String name;
	private String surname;
	private String email;
	private Double price;
	private String department;
}
