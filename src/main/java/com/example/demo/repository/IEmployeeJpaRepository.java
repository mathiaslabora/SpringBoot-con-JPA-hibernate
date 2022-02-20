package com.example.demo.repository;

import com.example.demo.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IEmployeeJpaRepository extends JpaRepository<Employee, Long>{
   //selecciona de employee cuando employeeid = [param]
    Employee findByEmployeeid(String employeeid);
    


}
