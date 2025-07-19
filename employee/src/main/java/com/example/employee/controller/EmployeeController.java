package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeJpaService;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    public EmployeeJpaService service;

    @GetMapping("/employees")
    public ArrayList<Employee> getEmployees() {
        return service.getEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") int employeeId) {
        return service.getEmployeeById(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable int employeeId, @RequestBody Employee employee) {
        return service.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") int employeeId) {
        service.deleteEmployee(employeeId);
    }
}