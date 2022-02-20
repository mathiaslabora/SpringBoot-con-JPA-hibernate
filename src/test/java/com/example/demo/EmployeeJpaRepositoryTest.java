package com.example.demo;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.model.Employee;
import com.example.demo.repository.IEmployeeJpaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmployeeJpaRepositoryTest {
    @Autowired
    private IEmployeeJpaRepository repo;
    
@Test
public void saveEmployee(){
Employee jhon = new Employee("jhon", "smith", "empl123");
Employee claire = new Employee("claire", "simpson", "empl12342");

repo.save(jhon);
repo.save(claire);

repo.flush();

assertEquals(2, repo.findAll().size());



}
}
