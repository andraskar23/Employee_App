package com.yash.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeRequest {
	
	private String ename;
	private String designation;
	private double salary;

}
