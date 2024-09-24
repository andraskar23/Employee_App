package com.yash.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="emp")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="eid")
	private long eid;
	@Column(name="ename")
	private String ename;
	@Column(name="designation")
	private String designation;
	@Column(name="salary")
	private double salary;

}
