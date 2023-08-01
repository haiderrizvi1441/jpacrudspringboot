package com.hr.anothercruddemo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hr.anothercruddemo.Entity.Employee;
import com.hr.anothercruddemo.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    // Constructor injecting EmployeeRepository
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployess() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int Id) {
        Employee employee = null;
        employee = employeeRepository.findById(Id).get();
        if(employee==null){
            throw new RuntimeException("Student not found , try again with the correct id");
        }
        return employee;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
        
        
    }

    @Override
    public void updateEmployeeById(Employee employee) {
        
        // Get the exisiting employee using the id of input id
        Employee existingEmployee = employeeRepository.findById(employee.getId()).orElse(null);
        // Transfer the new properties from new to exisitng employee
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        // Save the upadted employee
        employeeRepository.save(existingEmployee);

    }

    @Override
    public void deleteEmployeeById(int Id) {
        Employee employee = employeeRepository.findById(Id).get();
        employeeRepository.delete(employee);
        System.out.println("Employee: " + Id + " deleted sucessfully");
    }

    @Override
    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }
    

}
