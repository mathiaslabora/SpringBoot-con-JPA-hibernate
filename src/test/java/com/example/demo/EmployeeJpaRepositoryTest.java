package com.example.demo;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDataBase(replace = Replace.NONE)
public class EmployeeJpaRepositoryTest {
    
}