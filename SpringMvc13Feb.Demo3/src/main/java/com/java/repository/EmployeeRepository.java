package com.java.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.java.dto.Employee;

@Repository
public class EmployeeRepository {

	Map<Integer, Employee> db= new HashMap<>();
	
	public Collection<Employee> getEmployees(){
		return db.values();
	}
	
	public Employee getEmployeeById(int id) {
		return db.get(id);
	}
	
	public void addEmployee(Employee e) {
		db.put(e.id, e);
	}
	
	public void removeEmployee(int id) {
		db.remove(id);
	}
	
	public void updateEmployee(Employee e) {
		db.put(e.id, e);
	}
}
