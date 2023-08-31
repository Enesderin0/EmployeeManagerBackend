package com.EmployeeManager.EmployeeManager.dto.responses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteEmployeeResponse {

	private String name;
	private String surname;
}
