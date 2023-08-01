package com.hr.anothercruddemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.anothercruddemo.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    
}
