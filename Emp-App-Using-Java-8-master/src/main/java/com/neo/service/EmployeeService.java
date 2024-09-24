package com.neo.service;

import java.util.List;

import com.neo.dto.EmployeeRequest;
import com.neo.dto.EmployeeResponse;


public interface EmployeeService {

	public void createEmployee(EmployeeRequest employeeRequest);
	
	public List<EmployeeResponse> getAllEmployees();
	
	public EmployeeResponse getEmployeeById(Long eid);
	
	public EmployeeResponse updateEmployee(Long eid,EmployeeRequest employeeRequest);
	
	public void deleteEmployee(Long eid);
	
	
	
}
