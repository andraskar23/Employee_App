package com.neo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeResponse {

	private long eid;
	private String ename;
	private String designation;
	private double salary;
}
