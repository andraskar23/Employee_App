package com.neo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.neo.dto.EmployeeRequest;
import com.neo.dto.EmployeeResponse;
import com.neo.service.EmployeeServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {

	
	private final EmployeeServiceImpl employeeServiceImpl;

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void createEmployee(@RequestBody EmployeeRequest employeeRequest) {
		employeeServiceImpl.createEmployee(employeeRequest);
	}

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<EmployeeResponse> getAllEmployees() {
		return employeeServiceImpl.getAllEmployees();
	}

	@GetMapping("/getEmployee/{eid}")
	@ResponseStatus(HttpStatus.OK)
	public EmployeeResponse getEmployeeById(@PathVariable Long eid) {
		return employeeServiceImpl.getEmployeeById(eid);
	}

	@PutMapping("/updateEmployee/{eid}")
	@ResponseStatus(HttpStatus.OK)
	public EmployeeResponse updateEmployee(@PathVariable Long eid,@RequestBody EmployeeRequest employeeRequest) {
		return employeeServiceImpl.updateEmployee(eid, employeeRequest);
	}
	
	@DeleteMapping("/deleteEmployee/{eid}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteEmployee(@PathVariable Long eid) {
		 employeeServiceImpl.deleteEmployee(eid);
	}

}
