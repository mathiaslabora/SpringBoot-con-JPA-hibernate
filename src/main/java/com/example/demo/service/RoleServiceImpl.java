package com.example.demo.service;

import com.example.demo.dto.RoleDto;
import com.example.demo.model.Role;
import com.example.demo.repository.IRoleJpaRepository;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * RoleServiceImpl
 */

 @Service
 @Validated
public class RoleServiceImpl implements IRoleService {

    @Autowired
private IRoleJpaRepository roleRepo;

@Autowired
private ModelMapper modelMapper;

    @Override
    public RoleDto create(RoleDto role) {
        // TODO Auto-generated method stub
        Role roleEntity = modelMapper.map(role, Role.class);
        roleRepo.save(roleEntity);
        return modelMapper.map(roleEntity, RoleDto.class);
    }

    
}