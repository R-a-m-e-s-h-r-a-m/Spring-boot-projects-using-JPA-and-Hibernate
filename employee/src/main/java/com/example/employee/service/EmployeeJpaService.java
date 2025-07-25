package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.EmployeeJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;

@Service
public class EmployeeJpaService implements EmployeeRepository {

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    @Override
    public ArrayList<Employee> getEmployees() {
        return new ArrayList<>(employeeJpaRepository.findAll());
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        try {
            Employee employee = employeeJpaRepository.findById(employeeId).get();
            return employee;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeJpaRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(int employeeId, Employee employee) {

        try {
            Employee newEmployee = employeeJpaRepository.findById(employeeId).get();
            if (newEmployee.getEmployeeName() != null) {
                newEmployee.setEmployeeName(employee.getEmployeeName());
            }
            if (newEmployee.getEmail() != null) {
                newEmployee.setEmail(employee.getEmail());
            }
            if (newEmployee.getDepartment() != null) {
                newEmployee.setDepartment(employee.getDepartment());
            }
            return employeeJpaRepository.save(newEmployee);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public void deleteEmployee(int employeeId) {

        try {
            employeeJpaRepository.deleteById(employeeId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
}