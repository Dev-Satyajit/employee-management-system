package com.satyajit.employeemanagementsystem.service;

import java.util.List;

import com.satyajit.employeemanagementsystem.model.Employee;

public interface EmsService {
	Employee createEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(int id);

	List<Employee> getEmployeesByName(String name);

	List<Employee> getEmployeesBySalary(Double salary);

	Employee updatEmployeeByid(int id, Employee employee);

	String deleteEmployeeById(int id);

	String deleteAllEmployees();
}
