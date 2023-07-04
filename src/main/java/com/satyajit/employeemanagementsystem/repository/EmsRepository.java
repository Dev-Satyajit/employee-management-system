package com.satyajit.employeemanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satyajit.employeemanagementsystem.model.Employee;

public interface EmsRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByName(String name);

	List<Employee> findBySalary(Double salary);

}
