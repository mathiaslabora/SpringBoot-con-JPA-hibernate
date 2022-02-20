package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Employee;
import com.example.demo.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IEmployeeJpaRepository extends JpaRepository<Employee, Long>{
   //selecciona de employee cuando employeeid = [param]
    Employee findByEmployeeid(String employeeid);
    List<Employee> findByLastName(String lastName);
    List<Employee> findByRole(Role role);
    

}
