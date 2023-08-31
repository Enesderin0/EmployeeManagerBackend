package com.EmployeeManager.EmployeeManager.config.modelMapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	public ModelMapper forResponses();
	public ModelMapper forRequest();
}
