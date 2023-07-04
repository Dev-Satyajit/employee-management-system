package com.satyajit.employeemanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyajit.employeemanagementsystem.exception.DataNotFoundException;
import com.satyajit.employeemanagementsystem.model.Employee;
import com.satyajit.employeemanagementsystem.repository.EmsRepository;

@Service
public class EmsServiceImpl implements EmsService {

	@Autowired
	private EmsRepository repository;

	@Override
	public Employee createEmployee(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = repository.findAll();
		if (employees.isEmpty())
			throw new DataNotFoundException("No employees found");
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElseThrow(() -> new DataNotFoundException("Employee not found"));
	}

	@Override
	public List<Employee> getEmployeesByName(String name) {
		List<Employee> employees = repository.findByName(name);
		if (employees.isEmpty())
			throw new DataNotFoundException("No employees found");
		return employees;
	}

	@Override
	public List<Employee> getEmployeesBySalary(Double salary) {
		List<Employee> employees = repository.findBySalary(salary);
		if (employees.isEmpty())
			throw new DataNotFoundException("No employees found");
		return employees;
	}

	@Override
	public Employee updatEmployeeByid(int id, Employee newEmployee) {
		Employee oldEmployee = repository.findById(id)
				.orElseThrow(() -> new DataNotFoundException("Employee not found"));
		if (newEmployee.getName() != null)
			oldEmployee.setName(newEmployee.getName());
		if (newEmployee.getEmailId() != null)
			oldEmployee.setEmailId(newEmployee.getEmailId());
		if (newEmployee.getDepartmentId() != 0)
			oldEmployee.setDepartmentId(newEmployee.getDepartmentId());
		if (newEmployee.getDepartmentName() != null)
			oldEmployee.setDepartmentName(newEmployee.getDepartmentName());
		if (newEmployee.getSalary() != null)
			oldEmployee.setSalary(newEmployee.getSalary());
		if (newEmployee.getDesignation() != null)
			oldEmployee.setDesignation(newEmployee.getDesignation());
		return repository.save(oldEmployee);
	}

	@Override
	public String deleteEmployeeById(int id) {
		Employee employee = repository.findById(id).orElseThrow(() -> new DataNotFoundException("Employee not found"));
		repository.delete(employee);
		return "Employee details deleted successfully.";
	}

	@Override
	public String deleteAllEmployees() {
		List<Employee> employees = repository.findAll();
		if (employees.isEmpty())
			throw new DataNotFoundException("No employees found");
		repository.deleteAll();
		return "All employee details deleted successfully.";
	}

}
