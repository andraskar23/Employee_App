package com.yash.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.yash.dto.EmployeeRequest;
import com.yash.dto.EmployeeResponse;
import com.yash.exception.EmployeeNotFoundException;
import com.yash.model.Employee;
import com.yash.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepository employeeRepository;

	@Override
	public void createEmployee(EmployeeRequest employeeRequest) {
		
		
		// Map the ProductRequest to Product model
				Employee employee = Employee.builder() // to build the Employee object
						.ename(employeeRequest.getEname())
						.designation(employeeRequest.getDesignation())
						.salary(employeeRequest.getSalary())
						.build(); // It will build the object of type Employee with all
								 // the request details

				// Created instance of Employee object
				
				// Saving it into database
				employeeRepository.save(employee);

	}

	@Override
	public List<EmployeeResponse> getAllEmployees() {
		
		List<Employee> employees = employeeRepository.findAll();
		//Map Product class into ProductResponse class
		return employees.stream().map(this::mapToEmployeeResponse).toList();
	}
	
	private EmployeeResponse mapToEmployeeResponse(Employee employee) {
		return EmployeeResponse.builder()
				.eid(employee.getEid())
				.ename(employee.getEname())
				.designation(employee.getDesignation())
				.salary(employee.getSalary())
				.build(); // create object of ProductResponse
	}

	@Override
	public EmployeeResponse getEmployeeById(Long eid) {
		
		Optional<Employee> empId = employeeRepository.findById(eid);
		
		return empId.map(this::mapToEmployeeResponse)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for the "+eid));
	}

	@Override
	public EmployeeResponse updateEmployee(Long eid, EmployeeRequest employeeRequest) {
	    Optional<Employee> existingEmployee = employeeRepository.findById(eid);
	 
	    if (existingEmployee.isPresent()) {
	        Employee employee = existingEmployee.get();
	 
	        // Update employee details based on the employeeRequest
	        employee.setEname(employeeRequest.getEname());
	        employee.setSalary(employeeRequest.getSalary());
	        employee.setDesignation(employeeRequest.getDesignation());
	 
	        Employee updatedEmployee = employeeRepository.save(employee);
	 
	        return mapToEmployeeResponse(updatedEmployee);
	    } else {
	        throw new EmployeeNotFoundException("Employee with ID " + eid + " not found");
	    }
	}

	@Override
	public void deleteEmployee(Long eid) {
		
		Optional<Employee> id = employeeRepository.findById(eid);
		
		id.ifPresent(employee -> {
			employeeRepository.delete(employee);
		});
		
	}

	
}
