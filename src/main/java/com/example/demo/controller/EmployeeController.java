package com.example.demo.controller;
import com.example.demo.model.Employee;
import com.example.demo.model.employee;
import com.example.demo.repository.IEmployeeJpaRepository;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/employee")


public class EmployeeController {

    @Autowired
    IEmployeeJpaRepository iEmployeeJpaRepository;

@GetMapping("/all")
public ResponseEntity<List<Employee>> getAllEmployee(){
    try {
        List<Employee> employees = new ArrayList<Employee>();        
            iEmployeeJpaRepository.findAll().forEach(employees::add);        
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
//(String firstName, String lastName, String employeeid, Role role)
@PostMapping("/post")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        try {
            Employee _employee = iEmployeeJpaRepository
                    .save(new Employee(employee.getFirstName(), employee.getLastName(),employee.getEmployeeid(),employee.getRole()));
            return new ResponseEntity<>(_employee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
    
}
