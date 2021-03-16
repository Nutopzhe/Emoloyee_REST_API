package com.nikolayrybakov.spring.rest.controller;

import com.nikolayrybakov.spring.rest.entity.Employee;
import com.nikolayrybakov.spring.rest.exception_handling.EmployeeIncorrectData;
import com.nikolayrybakov.spring.rest.exception_handling.NoSuchEmployeeException;
import com.nikolayrybakov.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);

        if (employee == null) {
            throw new NoSuchEmployeeException("There is not employee with ID = " + id + " in database");
        }
        return employee;
    }
}
