package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.dao.EmployeeDao;
import com.rest.model.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = employeeDao.getAllEmployees();
		return list;
	}

	@Override
	public int addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	@Override
	public int updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}

	@Override
	public int deleteEmployee(Long employeeId) {
		return employeeDao.deleteEmployee(employeeId);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Employee employeeDetail = employeeDao.getEmployeeById(id);
		return employeeDetail;
	}
}
