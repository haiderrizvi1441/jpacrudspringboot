package com.hr.anothercruddemo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.hr.anothercruddemo.Entity.Employee;
import com.hr.anothercruddemo.Service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeRestController {
    
    private EmployeeService employeeService;
    // Inejcting Service using Constructor Injection
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    // To test
    @GetMapping("/test")
    public String testing(){
        return "API system is working fine ";
    }
    // To get all the employee
    @GetMapping("/employees") 
    public List<Employee> getAll(){
        return employeeService.getAllEmployess();
    }

    // To get employee by Id
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = null;
        employee = employeeService.getEmployeeById(id);
        if(employee == null){
            throw new RuntimeException("Employee : " + id + " not found in System");
        }
        return employee;
    }

    // To Save an Employee
    @PostMapping("/employee/")
    public String saveEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return "Employee is Added";
    }

    // To Update an Employee
    @PutMapping("/employee")
    public String updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployeeById(employee);
        return "Employee is updated";
    }   
}
