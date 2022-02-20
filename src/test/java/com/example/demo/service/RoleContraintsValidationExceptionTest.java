package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.validation.ConstraintViolationException;

import com.example.demo.dto.RoleDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RoleContraintsValidationExceptionTest {
    /**
     *
     */
    private static final String ADMIN = "ADMIN";
    @Autowired
    private RoleServiceImpl roleService;

    @Test
    public void contraintsValidationExceptionTest() {

assertThrows(ConstraintViolationException.class, ()->{roleService.create(new RoleDto(null));});
assertThrows(ConstraintViolationException.class, ()->{roleService.create(new RoleDto(""));});
assertThrows(ConstraintViolationException.class, ()->{roleService.create(new RoleDto("9876543210654321"));});
       
    }
@Test
    public void createRoleOk(){
          RoleDto roleDto = roleService.create(new RoleDto(ADMIN));
          assertNotNull(roleDto);
          assertEquals(ADMIN, roleDto.getName());
          assertNotNull(roleDto.getId());
    }
}
