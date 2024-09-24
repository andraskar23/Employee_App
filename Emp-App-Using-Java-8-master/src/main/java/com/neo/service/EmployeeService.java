package com.yash.service;

import java.util.List;
import java.util.Optional;

import com.yash.dto.EmployeeRequest;
import com.yash.dto.EmployeeResponse;


public interface EmployeeService {

	public void createEmployee(EmployeeRequest employeeRequest);
	
	public List<EmployeeResponse> getAllEmployees();
	
	public EmployeeResponse getEmployeeById(Long eid);
	
	public EmployeeResponse updateEmployee(Long eid,EmployeeRequest employeeRequest);
	
	public void deleteEmployee(Long eid);
	
	
	
}
