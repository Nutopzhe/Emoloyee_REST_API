package com.nikolayrybakov.spring.rest.service;

import com.nikolayrybakov.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    void saveEmployee(Employee emp);

    Employee getEmployeeById(int id);

    void deleteEmployee(int id);
}
