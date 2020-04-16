package com.rest.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rest.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public @ResponseBody int deleteEmployee(Long employeeId) {
		int flag = jdbcTemplate.update("DELETE FROM employee where employee_id = ?", new Object[] {employeeId});
		return flag;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = null;
		try {
			employeeList = jdbcTemplate.query("SELECT * FROM employee", new BeanPropertyRowMapper<Employee>(Employee.class));
		}catch(DataAccessException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	@Override
	public int addEmployee(Employee employee) {
		int flag = jdbcTemplate.update("INSERT INTO employee(employee_id, first_name, last_name, age) VALUES(?,?,?,?)",
				new Object[] {employee.getEmployeeId(),employee.getFirstName(), employee.getLastName(), employee.getAge()});
		return flag;
	}

	@Override
	public int updateEmployee(Employee employee) {
		int flag = jdbcTemplate.update("UPDATE employee set first_name = ?, last_name = ?, age = ? WHERE employee_id = ?",
				new Object[]{employee.getFirstName(), employee.getLastName(), employee.getAge(), employee.getEmployeeId()});
		return flag;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Employee employeeDetails = null;
		try {
			employeeDetails = jdbcTemplate.queryForObject("SELECT * FROM employee where employee_id = ?",
					new Object[] {id}, new BeanPropertyRowMapper<Employee>(Employee.class));
		}catch(DataAccessException e) {
			e.printStackTrace();
		}
		return employeeDetails;
	}
}