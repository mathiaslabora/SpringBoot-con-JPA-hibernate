package com.example.demo.service;

import javax.validation.Valid;

import com.example.demo.dto.RoleDto;

public interface IRoleService {
    public RoleDto create(@Valid RoleDto role);
}
