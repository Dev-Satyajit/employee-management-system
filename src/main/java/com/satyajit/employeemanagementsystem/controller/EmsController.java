package com.satyajit.employeemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.satyajit.employeemanagementsystem.model.Employee;
import com.satyajit.employeemanagementsystem.service.EmsService;

@RestController
@RequestMapping("/ems")
public class EmsController {

	@Autowired
	private EmsService service;

	@PostMapping("/save")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(service.createEmployee(employee), HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<>(service.getAllEmployees(), HttpStatus.OK);
	}

	@GetMapping("/id")
	public ResponseEntity<Employee> getEmployeeById(@RequestParam("value") int id) {
		return new ResponseEntity<>(service.getEmployeeById(id), HttpStatus.OK);
	}

	@GetMapping("/name")
	public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam("value") String name) {
		return new ResponseEntity<>(service.getEmployeesByName(name), HttpStatus.OK);
	}

	@GetMapping("/salary")
	public ResponseEntity<List<Employee>> getEmployeesBySalary(@RequestParam("value") Double salary) {
		return new ResponseEntity<>(service.getEmployeesBySalary(salary), HttpStatus.OK);
	}

	@PutMapping("/updateId")
	public ResponseEntity<Employee> updateEmployeeById(@RequestParam("value") int id, @RequestBody Employee employee) {
		return new ResponseEntity<>(service.updatEmployeeByid(id, employee), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteId")
	public ResponseEntity<String> deleteEmployeeById(@RequestParam("value") int id) {
		return new ResponseEntity<>(service.deleteEmployeeById(id), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAllEmployees() {
		return new ResponseEntity<>(service.deleteAllEmployees(), HttpStatus.ACCEPTED);
	}
	
}
