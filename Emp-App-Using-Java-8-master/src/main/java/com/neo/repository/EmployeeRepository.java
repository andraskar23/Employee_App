package com.neo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
