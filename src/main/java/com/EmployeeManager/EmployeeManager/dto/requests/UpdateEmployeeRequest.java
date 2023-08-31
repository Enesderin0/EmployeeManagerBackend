package com.EmployeeManager.EmployeeManager.dto.requests;
import java.io.File;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {
	private String name;
	private String surname;
	private File image;
	private String email;
	private Double price;
	private String department;
}
