package com.hr.anothercruddemo.Service;

import java.util.List;

import com.hr.anothercruddemo.Entity.Employee;

public interface EmployeeService {
    

    // Getting All Employees
    List<Employee> getAllEmployess();

    // Getting Employees by Id
    Employee getEmployeeById(int Id);

    // Save Employee
    Employee saveEmployee(Employee employee);

    // Updating Employee by Id
    void updateEmployeeById(Employee employee);

    // Deleting Employee by Id
    void deleteEmployeeById(int Id);

    // Deleting All Employee;
    void deleteAllEmployees();
}
