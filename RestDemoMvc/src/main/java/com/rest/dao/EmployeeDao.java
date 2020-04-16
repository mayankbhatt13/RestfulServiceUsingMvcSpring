package com.rest.dao;

import java.util.List;

import com.rest.model.Employee;

public interface EmployeeDao {
	public List<Employee> getAllEmployees();
	public int addEmployee(Employee employee);
	public int updateEmployee(Employee employee);
	public int deleteEmployee(Long employeeId);
	public Employee getEmployeeById(Long id);
}
